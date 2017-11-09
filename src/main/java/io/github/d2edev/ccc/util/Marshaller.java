package io.github.d2edev.ccc.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.base.ValueProvider;

public class Marshaller {

	public String marshall(Object request) throws MarshallException {
		Request command = request.getClass().getAnnotation(Request.class);
		if (command == null)
			throw new MarshallException("Object type must be annotated with @QueryCommand");
		StringBuilder builder = new StringBuilder("cmd").append("=").append(command.value());
		List<Entry<String, Object>> paramList = new ArrayList<>();
		fillParameterList(request, paramList);
		if (paramList.size() == 0)
			return builder.toString();
		int counter = 0;
		for (Entry<String, Object> entry : paramList) {
			builder.append("&").append("-").append(entry.getKey()).append("=").append(entry.getValue());
		}
		return builder.toString();
	}

	private void fillParameterList(Object request, List<Entry<String, Object>> list) throws MarshallException {
		Method[] methods = request.getClass().getDeclaredMethods();
		Field[] fields = request.getClass().getDeclaredFields();
		if (fields.length < 1)
			return;
		for (Method method : methods) {
			if (method.isAnnotationPresent(GetModelValue.class)) {
				try {
					String key = method.getAnnotation(GetModelValue.class).key();
					Object value = getPropertyFieldValue(method, request);
					list.add(new AbstractMap.SimpleEntry<>(key, value));
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
		return value;
	}

}
