package io.github.d2edev.ccc.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.models.ImageProperties;
import io.github.d2edev.ccc.models.NetworkProperties;
import io.github.d2edev.ccc.models.OSDProperties;
import io.github.d2edev.ccc.models.WirelessValidationResult;
import io.github.d2edev.ccc.requests.network.GetWirelessProperties;
import io.github.d2edev.ccc.requests.video.GetImageProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * class creator - based on server reply
 * 
 * @author ddmitry
 *
 */
public class GetSetCreator {

	private static final String CR = "\n";

	public static void main(String[] args) {
		try {
			String reply = GetSetCreator.createGetSet(NetworkProperties.class);
			System.out.println(reply);
		} catch (IOException | MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * returns string representing class skeleton - variables with annotated
	 * getters and setters
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws MarshallException
	 */
	public static String createGetSet(Class<?> clz) throws IOException, MarshallException {
		boolean parsed = false;
		Field[] fields = clz.getDeclaredFields();
		if (fields.length < 1)
			return "No fields in class " + clz.getName();
		StringBuilder b = new StringBuilder();
		for (Field field : fields) {
			if (!field.isAnnotationPresent(Key.class))
				continue;
			String key = field.getAnnotation(Key.class).value();
			Class<?> type = field.getType();
			String name = field.getName();
			String updName = name.substring(0, 1).toUpperCase() + name.substring(1);
			// setter
			b.append("//comment for setter related to [").append(key).append("] goes here").append(CR);
			b.append("@SetModelValue(key=\"").append(key).append("\")").append(CR);
			b.append("public void set").append(updName).append("(").append(type.getSimpleName()).append(" ").append(name)
					.append("){").append(CR);
			b.append("this.").append(name).append("=").append(name).append(";").append(CR);
			b.append("}").append(CR).append(CR);
			// getter
			b.append("//comment for getter related to [").append(key).append("] goes here").append(CR);
			b.append("@GetModelValue(key=\"").append(key).append("\")").append(CR);
			b.append("public ").append(type.getSimpleName()).append(" get").append(updName).append("(){").append(CR);
			b.append("return ").append(name).append(";").append(CR);
			b.append("}").append(CR).append(CR);
			parsed = true;

		}
		if (parsed) {
			return b.toString();
		} else {
			return "No annotated fields in class " + clz.getName();
		}

	}

	private static String getVarType(String value) {
		if (value == null || value.equals(""))
			return "String";
		if (value.toLowerCase().equals("true"))
			return "boolean";
		if (value.toLowerCase().equals("false"))
			return "boolean";
		try {
			Integer.parseInt(value);
			return "int";
		} catch (Exception e) {
			// System.out.println("not int");
		}
		try {
			Float.parseFloat(value);
			return "float";

		} catch (Exception e) {
			// System.out.println("not float");
		}
		return "String";
	}

}
