package io.github.d2edev.ccc.util;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.base.QuerySet;
import io.github.d2edev.ccc.objects.base.ValueProvider;

public class Marshaller {

	public String marshall(Object request) throws MarshallException {
		QueryCommand command = request.getClass().getAnnotation(QueryCommand.class);
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
		Field[] fields = request.getClass().getDeclaredFields();
		if (fields.length < 1)
			return;
		for (Field field : fields) {
			if (field.isAnnotationPresent(QueryParameter.class)) {
				try {
					if(field.getAnnotation(QueryParameter.class).out()) {
						String key = field.getAnnotation(QueryParameter.class).set();
						if(QueryParameter.EMPTY.equals(key)){
							key=field.getAnnotation(QueryParameter.class).get();
						}
						Object value = getPropertyFieldValue(field, request);
						list.add(new AbstractMap.SimpleEntry<>(key, value));						
					}
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
			if (field.isAnnotationPresent(QuerySet.class)) {
				try {
					boolean accessDenied = !field.isAccessible();
					if (accessDenied) {
						field.setAccessible(true);
					}
					Object value = field.get(request);
					if (accessDenied) {
						field.setAccessible(false);
					}
					fillParameterList(value, list);
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
		}
	}

	private Object getPropertyFieldValue(Field field, Object request)
			throws IllegalArgumentException, IllegalAccessException {
		Object value;
		boolean accessDenied = !field.isAccessible();
		if (accessDenied) {
			field.setAccessible(true);
		}
		value = field.get(request);
		if (accessDenied) {
			field.setAccessible(false);
		}
		if (value instanceof ValueProvider) {
			value = ((ValueProvider) value).value();
		}
		return value;
	}

}
