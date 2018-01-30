package io.github.d2edev.ccc.base;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.Marshaller;
import io.github.d2edev.ccc.api.ValueProvider;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class RequestMarshaller implements Marshaller<AbstractCamRequest, Request.Builder> {

	private static final byte[] EMPTY_BODY = new byte[0];

	@Override
	public Builder marshall(AbstractCamRequest request) throws MarshallException {
		if (request == null)
			throw new MarshallException("Null, can't marshall");
		StringBuilder urlBuilder = new StringBuilder(request.getBasicURL()).append(request.getEndpoint());
		Builder rqBuilder = new Request.Builder();
		String command = request.getCamCommand();
		String method = request.getMethod();
		RequestBody rb = null;
		List<Entry<String, Object>> paramList = new ArrayList<>();
		switch (method) {
		case AbstractCamRequest.METHOD_GET: {
			if (command != null && !command.isEmpty()) {
				urlBuilder.append("?cmd=").append(command);
				fillParameterList(request, paramList);
				for (Entry<String, Object> entry : paramList) {
					urlBuilder.append("&").append("-").append(entry.getKey()).append("=").append(entry.getValue());
				}
			}
			return rqBuilder.get().url(urlBuilder.toString());
		}
		case AbstractCamRequest.METHOD_POST: {
			if (command != null && !command.isEmpty()) {
				paramList.add(new AbstractMap.SimpleEntry<>("cmd", command));
			}
			fillParameterList(request, paramList);
			RequestBody rqBody = null;
			if (request.isBinary()) {
				MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();
				bodyBuilder.setType(MultipartBody.FORM);
				for (Entry<String, Object> entry : paramList) {
					Object data = entry.getValue();
					if (data instanceof File) {
						File file = (File) data;
						bodyBuilder.addFormDataPart(entry.getKey(), file.getName(),
								RequestBody.create(MediaType.parse("application/octet-stream"), file));
					}
				}
				rqBody = bodyBuilder.build();

			} else {
				FormBody.Builder bodyBuilder = new FormBody.Builder();
				for (Entry<String, Object> entry : paramList) {
					Object value = entry.getValue();
					bodyBuilder.add(entry.getKey(), entry.getValue().toString());
				}
				rqBody = bodyBuilder.build();
			}
			return rqBuilder.post(rqBody).url(urlBuilder.toString());
		}

		default:
			throw new MarshallException("Can't marshall, unknown http method: " + method);
		}
	}

	private void fillParameterList(Object request, List<Entry<String, Object>> list) throws MarshallException {
		Method[] methods = request.getClass().getDeclaredMethods();
		Field[] fields = request.getClass().getDeclaredFields();
		if (fields.length < 1)
			return;
		for (Method method : methods) {
			if (method.isAnnotationPresent(GetModelValue.class)) {
				try {
					String key = "-" + method.getAnnotation(GetModelValue.class).key();
					Object value = getPropertyFieldValue(method, request);
					if (value != null) {
						// ignore 'null' values
						list.add(new AbstractMap.SimpleEntry<>(key, value));
					}
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
			if (method.isAnnotationPresent(GetModel.class)) {
				try {
					boolean accessDenied = !method.isAccessible();
					if (accessDenied) {
						method.setAccessible(true);
					}
					Object value = method.invoke(request);
					if (accessDenied) {
						method.setAccessible(false);
					}
					fillParameterList(value, list);
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
		}
	}

	private Object getPropertyFieldValue(Method method, Object request)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Object value;
		boolean accessDenied = !method.isAccessible();
		if (accessDenied) {
			method.setAccessible(true);
		}
		value = method.invoke(request);
		if (accessDenied) {
			method.setAccessible(false);
		}
		if (value instanceof ValueProvider) {
			value = ((ValueProvider) value).value();
		}
		if (value instanceof String) {
			value = ((String) value).replace(' ', '+');
		}
		return value;
	}

}
