package io.github.d2edev.ccc.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.objects.requests.GetWirelessProperties;
import io.github.d2edev.ccc.util.MarshallException;
import io.github.d2edev.ccc.util.Marshaller;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * class creator - based on server reply
 * 
 * @author ddmitry
 *
 */
public class ClassCreator {

	private static final String CR = "\n";
	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.201/" + ENDPOINT + "?";

	public static void main(String[] args) {
		try {
			String reply = ClassCreator.createBase(new GetWirelessProperties());
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
	public static String createBase(Object request) throws IOException, MarshallException {
		OkHttpClient client = new OkHttpClient();
		String auth = "admin:admin";
		byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
		String content = "Basic " + new String(encoded);

		Marshaller m = new Marshaller();

		String cmd = PREFIX + m.marshall(request);
		// System.out.println(cmd);
		Request rq = new Request.Builder().url(cmd).addHeader("Authorization", content).build();
		Response r = client.newCall(rq).execute();
		return createClassFromReply(r.body().charStream());

	}

	public static String createClassFromReply(Reader stream) throws IOException {
		BufferedReader reader = new BufferedReader(stream);
		Map<String, String> parseMap = new HashMap<>();
		List<String> lines = new ArrayList<>();
		String value = null;
		try {
			while ((value = reader.readLine()) != null) {
				// typical representation is: var bps_1="1000" or var
				// width_1="1280"
				lines.add(value);
				String[] pair = value.substring(4).split("=");
				if (pair.length != 2)
					continue; // ignore if not pair
				String key = pair[0];
				// value = pair[1].replaceAll("\"", "").replaceAll(";", "");
				value = pair[1].substring(1, pair[1].length() - 2);
				parseMap.put(key, value);
			}
			if (parseMap.size() == 0)
				return null;
			StringBuilder b = new StringBuilder();
			b.append("// ***Gerated automatically ***").append(CR).append(CR);
			b.append("//response example:").append(CR);
			for (String string : lines) {
				b.append("//").append(string).append(CR);
			}
			b.append(CR);
			for (Entry<String, String> entry : parseMap.entrySet()) {
				
				String val = entry.getValue();
				String res=getVarType(val);
//				System.out.println(val+" -> "+res);
				entry.setValue(res);
			}
			// var declaration
			for (Entry<String, String> entry : parseMap.entrySet()) {
				b.append("//comment for variable linked to key").append(entry.getKey()).append(" goes here").append(CR);
				b.append("private ").append(entry.getValue()).append(" var_").append(entry.getKey()).append(";")
						.append(CR).append(CR);

			}
			// getters and setters
			for (Entry<String, String> entry : parseMap.entrySet()) {
				String key=entry.getKey();
				String updName = key.substring(0, 1).toUpperCase() + key.substring(1);
				//setter
				b.append("//comment for setter related to [").append(key).append("] goes here").append(CR);
				b.append("@SetModelValue(key=\"").append(key).append("\")").append(CR);
				b.append("public void set").append(updName).append("(").append(entry.getValue()).append(" ")
						.append(key).append("){").append(CR);
						b.append("this.var_").append(key).append("=").append(key).append(";").append(CR);
				b.append("}").append(CR).append(CR);
//getter
				b.append("//comment for getter related to [").append(key).append("] goes here").append(CR);
				b.append("@GetModelValue(key=\"").append(key).append("\")").append(CR);
				b.append("public ").append(entry.getValue()).append(" get").append(updName).append("(){").append(CR);
						b.append("return var_").append(key).append(";").append(CR);
				b.append("}").append(CR).append(CR);		
			}
			return b.toString();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {

				}
			}
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
//			System.out.println("not int");
		}
		try {
			Float.parseFloat(value);
				return "float";

		} catch (Exception e) {
//			System.out.println("not float");
		}
		return "String";
	}

}
