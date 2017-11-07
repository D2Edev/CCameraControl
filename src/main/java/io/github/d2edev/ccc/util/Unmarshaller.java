package io.github.d2edev.ccc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.objects.base.QueryInputParameterModifier;
import io.github.d2edev.ccc.objects.base.QueryParameter;

public class Unmarshaller {

	public <T> T unmarshall(Reader charStream, Class<T> returnClass) throws UnmarshallException, IOException {
		Map<String, Entry<Field, Object>> fieldMap = new HashMap<>();
		String modifier=null;
		if(returnClass.isAnnotationPresent(QueryInputParameterModifier.class)){
			modifier=returnClass.getAnnotation(QueryInputParameterModifier.class).value();
		}
		Field[] fields = returnClass.getDeclaredFields();
		if (fields.length == 0)
			throw new UnmarshallException("No fields in class " + returnClass.getName());
		for (Field field : fields) {
			if (field.isAnnotationPresent(QueryParameter.class)) {
				fieldMap.put(field.getAnnotation(QueryParameter.class).value(),
						new AbstractMap.SimpleEntry<>(field, null));
			}
		}
		if (fieldMap.size() == 0)
			throw new UnmarshallException("No '@QueryParameter'annotated fields in class " + returnClass.getName());
		String value = null;
		BufferedReader reader = new BufferedReader(charStream);
		try {
			while ((value = reader.readLine()) != null) {
				//typical representation is: var bps_1="1000" or var width_1="1280"
				String []pair=value.substring(4).split("=");
				if(pair.length!=2)continue;	//ignore if not pair
				String key=null;
				System.out.println(modifier);
				if(modifier==null){
					key = pair[0];
				}else{
					key=pair[0].substring(0, pair[0].indexOf(modifier));
				}
				value=pair[1].replaceAll("\"", "");
				System.out.println(key+" -> "+value);
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException none) {
				}
			}
		}

		return null;

	}

}
