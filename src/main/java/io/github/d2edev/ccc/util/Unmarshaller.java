package io.github.d2edev.ccc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.objects.base.QueryParameterSplitter;
import io.github.d2edev.ccc.objects.base.ValueProvider;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.base.QueryParameter;

public class Unmarshaller {

	public <T> T unmarshall(Reader charStream, Class<T> returnClass) throws UnmarshallException {
		if (returnClass == null)
			throw new UnmarshallException("Return type not provided");
		if(SimpleResponse.class.equals(returnClass)){
			return unmarshallSimpleObject(charStream,returnClass);
		}else{
			return unmarshalComplexObject(charStream, returnClass);			
		}
	}

	@SuppressWarnings("unchecked")
	public <T>T unmarshallSimpleObject(Reader charStream,Class<T> returnClass) throws UnmarshallException {
		BufferedReader reader = new BufferedReader(charStream);
		try {
			String line=null;
			boolean replyDetected=false;
			StringBuilder contentBuilder=new StringBuilder("Can't process. Unknown structure: ");
			String result=null;
			String message=null;
			try {
				while((line=reader.readLine())!=null){
					contentBuilder.append(line).append("<LineEnd>");
					if(line.startsWith("[")){
						result = line.substring(1, line.indexOf("]"));
						message=line.substring(line.indexOf("]")+1);
						replyDetected=true;
						break;
					}
				}
				if(replyDetected){
					switch (result.toLowerCase()) {
					case "succeed":{
						SimpleResponse response=new SimpleResponse();
						response.setSuccessfull(true);
						response.setMessage(message);
						return (T)response;
					}
					case "error":{
						SimpleResponse response=new SimpleResponse();
						response.setSuccessfull(false);
						response.setMessage(message);
						return (T)response;
					}		
					default:
						throw new UnmarshallException(contentBuilder.toString());
					}
				}else{
					
					throw new UnmarshallException(contentBuilder.toString());
				}
			} catch (IOException e) {
				throw new UnmarshallException(e.getMessage());
			}
		} finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException none) {
				}
			}
		}
	}

	private <T> T unmarshalComplexObject(Reader charStream, Class<T> returnClass) throws UnmarshallException {
		// prepare parse map using returnClass

		Map<String, Entry<Field, String>> parseMap = new HashMap<>();
		String modifier = null;
		boolean anyValue = false;
		if (returnClass.isAnnotationPresent(QueryParameterSplitter.class)) {
			modifier = returnClass.getAnnotation(QueryParameterSplitter.class).value();
		}
		Field[] fields = returnClass.getDeclaredFields();
		if (fields.length == 0)
			throw new UnmarshallException("No fields in class " + returnClass.getName());
		for (Field field : fields) {
			if (field.isAnnotationPresent(QueryParameter.class)) {
				parseMap.put(field.getAnnotation(QueryParameter.class).value(),
						new AbstractMap.SimpleEntry<>(field, null));
			}
		}
		if (parseMap.size() == 0)
			throw new UnmarshallException("No '@QueryParameter'annotated fields in class " + returnClass.getName());
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
				for (Entry<Field, String> entry : parseMap.values()) {
					Class<?> fieldClass = entry.getKey().getType();
					String inputValue = entry.getValue();
					if (inputValue == null || inputValue.isEmpty())
						continue;
					if (fieldClass.isEnum()) {
						if (ValueProvider.class.isAssignableFrom(fieldClass)) {
							// enum contains value behind it
							Method method = fieldClass.getMethod("values");
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
							setFieldValue(entry.getKey(), result, selectedObject);
						} else {
							// enum is just enum - get specific one using
							// 'valueOf'
							Method method = fieldClass.getMethod("valueOf", String.class);
							Object enumValue = method.invoke(null, inputValue);
							setFieldValue(entry.getKey(), result, enumValue);
						}
					} else {
						Object fieldValue = getTypedValue(inputValue, fieldClass);
						setFieldValue(entry.getKey(), result, fieldValue);
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

	private <T> void setFieldValue(Field field, T result, Object fieldValue)
			throws IllegalArgumentException, IllegalAccessException {
		boolean accesDenied = !field.isAccessible();
		if (accesDenied) {
			field.setAccessible(true);
		}
		field.set(result, fieldValue);
		if (accesDenied) {
			field.setAccessible(false);
		}

	}

	private Object getTypedValue(String value, Class<?> clazz) {
		// wrapper
		if (Boolean.class == clazz)
			return Boolean.parseBoolean(value);
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
			return Boolean.parseBoolean(value);
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

}
