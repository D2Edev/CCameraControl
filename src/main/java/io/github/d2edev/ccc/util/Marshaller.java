package io.github.d2edev.ccc.util;

import java.lang.reflect.Field;
import java.util.HashMap;
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
		String parameterString = createParameterString(request);
		if (parameterString != null) {
			builder.append("&").append(parameterString);
		}
		return builder.toString();
	}

	private String createParameterString(Object request) throws MarshallException {
		Field[] fields = request.getClass().getDeclaredFields();
		if (fields.length < 1)
			return null;
		StringBuilder builder = new StringBuilder();
		Map<String, Object> parametersMap = new HashMap<>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(QuerySet.class)) {
				try {
					boolean accessDenied=!field.isAccessible();
					if(accessDenied){
						field.setAccessible(true);
					}
					Object value = field.get(request);
					if(accessDenied){
						field.setAccessible(false);
					}
					builder.append(createParameterString(value));
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
			if (field.isAnnotationPresent(QueryParameter.class)) {
				try {
					String key = field.getAnnotation(QueryParameter.class).value();
					Object value= getPropertyFieldValue(field, request);
					parametersMap.put(key, value);
				} catch (Exception e) {
					throw new MarshallException(e.getMessage());
				}
			}
		}
		if (parametersMap.size() > 0) {
			int counter = 0;
			for (Entry<String, Object> entry : parametersMap.entrySet()) {
				counter++;
				builder
				.append("-")
				.append(entry.getKey())
				.append("=")
				.append(entry.getValue());
				if (counter == parametersMap.size())
					continue;
				builder.append("&");
			}
		}
		return builder.toString();
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
