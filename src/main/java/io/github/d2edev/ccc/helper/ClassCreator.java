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

public class ClassCreator {
	
	private static final String CR = "\n";
	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.201/"+ENDPOINT+"?";
	
	public static void main(String[] args) {
		try {
			String reply =ClassCreator.createBase(new GetWirelessProperties());
			System.out.println(reply);
		} catch (IOException | MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String createBase(Object request) throws IOException, MarshallException{
		OkHttpClient client = new OkHttpClient();
		String auth = "admin:admin";
		byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
		String content = "Basic " + new String(encoded);

		Marshaller m= new Marshaller();

		
			String cmd=PREFIX+m.marshall(request);
//			System.out.println(cmd);
			Request rq = new Request.Builder()
					.url(cmd)
					.addHeader("Authorization", content).build();
			Response r = client.newCall(rq).execute();
				return createClassFromReply(r.body().charStream());

	}

	public static String createClassFromReply(Reader stream) throws IOException{
		BufferedReader reader = new BufferedReader(stream);
		Map<String,String> parseMap=new HashMap<>();
		List<String> lines=new ArrayList<>();
		String value=null;
		try {
			while ((value = reader.readLine()) != null) {
				// typical representation is: var bps_1="1000" or var
				// width_1="1280"
				lines.add(value);
				String[] pair = value.substring(4).split("=");
				if (pair.length != 2)
					continue; // ignore if not pair
				String key= pair[0];
				// value = pair[1].replaceAll("\"", "").replaceAll(";", "");
				value = pair[1].substring(1, pair[1].length() - 2);
				parseMap.put(key, value);
			}
			if(parseMap.size()==0)return null;
			StringBuilder b=new StringBuilder();
			b.append("//response example:").append(CR);
			for (String string : lines) {
				b.append("//").append(string).append(CR);
				}
			b.append(CR);
			for (Entry<String,String> entry : parseMap.entrySet()) {
				b.append("//comment for ").append(entry.getKey()).append(" goes here").append(CR);
				b.append("@QueryParameter(get=\"").append(entry.getKey()).append("\")").append(CR);
				b.append("private String ").append(entry.getKey()).append(";").append(CR).append(CR);
				
			}
			return b.toString();
		} finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
				
				}
			}
		}
	}

}
