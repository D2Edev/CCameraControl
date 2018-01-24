package io.github.d2edev.ccc.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.Marshaller;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.ValueProvider;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class RequestMarshaller implements Marshaller<AbstractCamRequest, Request.Builder> {

	@Override
	public Builder marshall(AbstractCamRequest request) throws MarshallException {
		if (request == null)
			throw new MarshallException("Null, can't marshall");
		String url = request.getBasicURL() + request.getEndpoint();
//		System.out.println(url);
		List<Entry<String, Object>> paramList = new ArrayList<>();
		paramList.add(new AbstractMap.SimpleEntry<>("cmd", request.getCamCommand()));
		fillParameterList(request, paramList);
		FormBody.Builder bodyBuilder = new FormBody.Builder();
		for (Entry<String, Object> entry : paramList) {
			bodyBuilder.add(entry.getKey(), entry.getValue().toString());
		}
		System.out.println(paramList);
		Builder rqb = new Request.Builder().url(url).post(bodyBuilder.build());
		return rqb;
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
