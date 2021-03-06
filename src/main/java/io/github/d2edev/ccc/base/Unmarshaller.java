package io.github.d2edev.ccc.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.QueryParameterSplitter;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.api.ValueProvider;
import io.github.d2edev.ccc.enums.WiFiSecurityMode;
import io.github.d2edev.ccc.enums.WifiKeyEncryption;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.models.WirelessNetworks;
import okhttp3.Response;

public class Unmarshaller {

	Pattern netElementPattern = Pattern.compile("(\\w+)\\[(\\d+)\\]=\\\"(.+)\\\".*");

	public <T> T unmarshall(Response response, Class<T> returnClass) throws UnmarshallException {
		if (returnClass == null)
			throw new UnmarshallException("Null return argument");
		if (returnClass.equals(byte[].class)) {
			try {
				return (T) response.body().bytes();
			} catch (IOException e) {
				throw new UnmarshallException(e.getMessage());
			}
		}
		if (!returnClass.isAnnotationPresent(Model.class)) {
			throw new UnmarshallException("Model type not set");
		}
		String modelType = returnClass.getAnnotation(Model.class).value();
		switch (modelType) {
		case Model.SIMPLE: {
			return unmarshallSimpleObject(response, returnClass);
		}
		case Model.COMPLEX: {
			return unmarshalComplexObject(response.body().charStream(), returnClass);
		}
		case Model.NETWORKLIST: {
			return unmarshalNetworkList(response.body().charStream(), returnClass);
		}
		default:
			throw new UnmarshallException("Unknown return type");
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T unmarshalNetworkList(Reader charStream, Class<T> returnClass) throws UnmarshallException {
		BufferedReader reader = new BufferedReader(charStream);
		try {
			String line = null;
			boolean replyDetected = false;
			StringBuilder contentBuilder = new StringBuilder("Can't process. Unknown structure: ");
			Map<String, WirelessNetwork> networkMap = new HashMap<>();
			try {
				while ((line = reader.readLine()) != null) {
					Matcher eltMatcher = netElementPattern.matcher(line);
					if (eltMatcher.matches()) {
						String varName = eltMatcher.group(1);
						String key = eltMatcher.group(2);
						String value = eltMatcher.group(3);
						// System.out.println(varName+":"+key+":"+value);
						WirelessNetwork network = networkMap.get(key);
						if (network == null) {
							network = new WirelessNetwork();
							networkMap.put(key, network);
						}
						try {
							updateNetworkParameter(network, varName, value);
						} catch (Exception e) {
							// TODO process somehow?
						}
					}
				}
				if (networkMap.isEmpty())
					throw new UnmarshallException("No network data in input stream");
				WirelessNetworks networks = new WirelessNetworks();
				networks.setNetworks(new ArrayList<>(networkMap.values()));
				return (T) networks;
			} catch (IOException e) {
				throw new UnmarshallException(e.getMessage());
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException none) {
				}
			}
		}
	}

	private void updateNetworkParameter(WirelessNetwork network, String varName, String value) throws Exception {
		switch (varName) {
		case "wchannel": {
			network.setChannel((int) getTypedValue(value, int.class));
			break;
		}
		case "wrssi": {
			network.setStrength((int) getTypedValue(value, int.class));
			break;
		}
		case "wenc": {
			network.setKeyEncryption(WifiKeyEncryption.valueOf(value));
			break;
		}
		case "wessid": {
			network.setSSID(value);
			break;
		}
		case "wauth": {
			network.setWiFiSecurityMode(WiFiSecurityMode.parseString(value));
			break;
		}
		default:
			break;
		}

	}

	@SuppressWarnings("unchecked")
	private <T> T unmarshallSimpleObject(Response response, Class<T> returnClass) throws UnmarshallException {
		String reply;
		try {
			reply = response.body().string().toLowerCase();
			if (reply.contains("succeed")) {
				SimpleResponse r = new SimpleResponse();
				r.setSuccessfull(true);
				r.setMessage(reply);
				return (T) r;
			}
			if (reply.contains("error")) {
				SimpleResponse r = new SimpleResponse();
				r.setSuccessfull(false);
				r.setMessage(reply);
				return (T) r;
			}
			throw new UnmarshallException("Can't ubnmarshall: " + reply);
		} catch (IOException e) {
			throw new UnmarshallException("Can't ubnmarshall: " + e.getMessage());
		}
	}

	private <T> T unmarshalComplexObject(Reader charStream, Class<T> returnClass) throws UnmarshallException {
		// prepare parse map using returnClass

		Map<String, Entry<Method, String>> parseMap = new HashMap<>();
		String modifier = null;
		boolean anyValue = false;
		if (returnClass.isAnnotationPresent(QueryParameterSplitter.class)) {
			modifier = returnClass.getAnnotation(QueryParameterSplitter.class).value();
		}
		Method[] methods = returnClass.getDeclaredMethods();
		if (methods.length == 0)
			throw new UnmarshallException("No methods in object " + returnClass.getName());
		for (Method method : methods) {
			if (method.isAnnotationPresent(SetModelValue.class)) {
				parseMap.put(method.getAnnotation(SetModelValue.class).key(),
						new AbstractMap.SimpleEntry<>(method, null));
			}
		}
		if (parseMap.size() == 0)
			throw new UnmarshallException("Found no marked methods in class " + returnClass.getName());
		String value = null;
		BufferedReader reader = new BufferedReader(charStream);
		try {
			// parse values to map
			try {
				while ((value = reader.readLine()) != null) {
					// typical representation is: var bps_1="1000" or var
					// width_1="1280"
					String[] pair = value.substring(4).split("=");
					if (pair.length != 2)
						continue; // ignore if not pair
					String key = null;
					if (modifier == null) {
						key = pair[0];
					} else {
						key = pair[0].substring(0, pair[0].indexOf(modifier));
					}
					// value = pair[1].replaceAll("\"", "").replaceAll(";", "");
					value = pair[1].substring(1, pair[1].length() - 2);
					if (parseMap.containsKey(key)) {
						parseMap.get(key).setValue(value);
						anyValue = true;
					}
				}
			} catch (IOException e) {
				throw new UnmarshallException(e.getMessage());
			}
			if (!anyValue)
				return null;
			// inflate values to newly created object
			try {
				T result = returnClass.newInstance();
				for (Entry<Method, String> entry : parseMap.values()) {
					Method m = entry.getKey();
					Class<?>[] inputTypes = m.getParameterTypes();
					if (inputTypes.length != 1)
						throw new UnmarshallException("Wrong arguments number for method " + m.getName()
								+ ". Expected 1, found " + inputTypes.length);
					Class<?> clazz = inputTypes[0];// use first parameter
					String inputValue = entry.getValue();
					if (inputValue == null || inputValue.isEmpty())
						continue;
					if (clazz.isEnum()) {
						if (ValueProvider.class.isAssignableFrom(clazz)) {
							// enum contains value behind it
							Method method = clazz.getMethod("values");
							Object[] objectArray = (Object[]) method.invoke(null);
							Object selectedObject = null;
							for (Object object : objectArray) {
								if (object instanceof ValueProvider) {
									ValueProvider p = ValueProvider.class.cast(object);
									if (inputValue.equals(p.stringValue())) {
										selectedObject = p;
										break;
									}
								}
							}
							if (selectedObject == null)
								continue;
							invokeMethod(m, result, selectedObject);
						} else {
							// enum is just enum - get specific one using
							// 'valueOf'
							Method method = clazz.getMethod("valueOf", String.class);
							Object enumValue = method.invoke(null, inputValue);
							invokeMethod(m, result, enumValue);
						}
					} else {
						Object fieldValue = getTypedValue(inputValue, clazz);
						invokeMethod(m, result, fieldValue);
					}
				}
				return result;
			} catch (Exception e) {
				throw new UnmarshallException(e.getMessage());
				// throw e;
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException none) {
				}
			}
		}
	}

	private <T> void invokeMethod(Method method, T result, Object fieldValue)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		boolean accesDenied = !method.isAccessible();
		if (accesDenied) {
			method.setAccessible(true);
		}
		method.invoke(result, fieldValue);
		if (accesDenied) {
			method.setAccessible(false);
		}

	}

	private Object getTypedValue(String value, Class<?> clazz) {
		// wrapper
		if (Boolean.class == clazz)
			return treatAsBoolean(value);
		if (Byte.class == clazz)
			return Byte.parseByte(value);
		if (Short.class == clazz)
			return Short.parseShort(value);
		if (Integer.class == clazz)
			return Integer.parseInt(value);
		if (Long.class == clazz)
			return Long.parseLong(value);
		if (Float.class == clazz)
			return Float.parseFloat(value);
		if (Double.class == clazz)
			return Double.parseDouble(value);
		// primitive
		if (boolean.class == clazz)
			return treatAsBoolean(value);
		if (byte.class == clazz)
			return Byte.parseByte(value);
		if (short.class == clazz)
			return Short.parseShort(value);
		if (int.class == clazz)
			return Integer.parseInt(value);
		if (long.class == clazz)
			return Long.parseLong(value);
		if (float.class == clazz)
			return Float.parseFloat(value);
		if (double.class == clazz)
			return Double.parseDouble(value);
		return value;
	}

	private Object treatAsBoolean(String value) {
		if ("on".equals(value.toLowerCase()))
			return Boolean.TRUE;
		if ("enabled".equals(value.toLowerCase()))
			return Boolean.TRUE;
		if ("1".equals(value.toLowerCase()))
			return Boolean.TRUE;
		if ("true".equals(value.toLowerCase()))
			return Boolean.TRUE;
		if ("off".equals(value.toLowerCase()))
			return Boolean.FALSE;
		if ("disabled".equals(value.toLowerCase()))
			return Boolean.FALSE;
		if ("0".equals(value.toLowerCase()))
			return Boolean.FALSE;
		if ("false".equals(value.toLowerCase()))
			return Boolean.FALSE;
		throw new IllegalArgumentException("Cant't treat as boolean: " + value);

	}

}
