package io.github.d2edev.ccc.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.Marshaller;
import io.github.d2edev.ccc.api.ValueProvider;

public class StringMarshaller implements Marshaller<Object,String> {

	@Override
	public String marshall(Object object) throws MarshallException {
		CamRequest request = object.getClass().getAnnotation(CamRequest.class);
		if (request == null)
			throw new MarshallException("Object type must be annotated with @Request");
		StringBuilder builder = new StringBuilder(request.endpoint());
		String command=request.cmd();
		if(command.isEmpty()) return builder.toString();
		builder.append("cmd").append("=").append(command);
		List<Entry<String, Object>> paramList = new ArrayList<>();
		fillParameterList(object, paramList);
		if (paramList.size() == 0)
			return builder.toString();
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
					if(value!=null){
						//ignore 'null' values
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
