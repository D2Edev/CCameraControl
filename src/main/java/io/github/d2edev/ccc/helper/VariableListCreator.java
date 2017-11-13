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

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.WiFiSecurityMode;
import io.github.d2edev.ccc.enums.WifiInfrastructureMode;
import io.github.d2edev.ccc.enums.WifiKeyEncryption;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.requests.network.PrepareWirelessValidation;
import io.github.d2edev.ccc.requests.network.GetNetworkProperties;
import io.github.d2edev.ccc.requests.network.GetWirelessProperties;
import io.github.d2edev.ccc.requests.network.GetWirelessValidation;
import io.github.d2edev.ccc.requests.video.GetImageProperties;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * class creator - based on server reply
 * 
 * @author ddmitry
 *
 */
public class VariableListCreator {

	private static final String CR = "\n";
	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.201/" + ENDPOINT + "?";

	public static void main(String[] args) {
		try {
			
			String reply = VariableListCreator.createBase(new GetNetworkProperties());
			System.out.println(reply);
		} catch (IOException | MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * returns string representing class skeleton - variables
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
		 System.out.println(cmd);
		Request rq = new Request.Builder().url(cmd).addHeader("Authorization", content).build();
		Response r = client.newCall(rq).execute();
		return createClassFromReply(r.body().charStream());

	}

	public static String createClassFromReply(Reader stream) throws IOException {
		BufferedReader reader = new BufferedReader(stream);
		Map<String, String> parseMap = new HashMap<>();
		String value = null;
		try {
			while ((value = reader.readLine()) != null) {
				// typical representation is: var bps_1="1000" or var
				// width_1="1280"
				String[] pair = value.substring(4).split("=");
				if (pair.length != 2)
					continue; // ignore if not pair
				String key = pair[0];
				// value = pair[1].replaceAll("\"", "").replaceAll(";", "");
//				value = pair[1].substring(1, pair[1].length() - 2);
				parseMap.put(key, value);
			}
			if (parseMap.size() == 0)
				return null;
			StringBuilder b = new StringBuilder();
			b.append("// ***Generated automatically ***").append(CR).append(CR);
			// var declaration
			for (Entry<String, String> entry : parseMap.entrySet()) {
				b.append("//reply example: ").append(entry.getValue()).append(CR);
				b.append("//comment for variable linked to key [").append(entry.getKey()).append("] goes here").append(CR);
				b.append("@Key(\"").append(entry.getKey()).append("\")").append(CR);
				b.append("private Object ").append(entry.getKey()).append(";")
						.append(CR).append(CR);

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


}
