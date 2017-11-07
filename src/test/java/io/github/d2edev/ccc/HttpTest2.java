package io.github.d2edev.ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Base64;

import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.models.VideoProperties;
import io.github.d2edev.ccc.objects.requests.GetVideoEncoderProperties;
import io.github.d2edev.ccc.objects.requests.SetVideoProperties;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.StreamID;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.VideoMode;
import io.github.d2edev.ccc.util.MarshallException;
import io.github.d2edev.ccc.util.Marshaller;
import io.github.d2edev.ccc.util.UnmarshallException;
import io.github.d2edev.ccc.util.Unmarshaller;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpTest2 {

	private static final String PREFIX = "http://192.168.0.201/cgi-bin/hi3510/param.cgi?";

	public static void main(String[] args) {
		new HttpTest2().get();
	}

	// @Test
	public void set() {
		System.out.println("running sync set");
		OkHttpClient client = new OkHttpClient();
		String auth = "admin:admin";
		byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
		String content = "Basic " + new String(encoded);
		System.out.println(content);
		VideoProperties props=new VideoProperties();
		props.setFormat(TVFormat.PAL);
		props.setProfile(H264profile.BASELINE);
		props.setVideoMode(VideoMode._1280x720_640x352);
		SetVideoProperties svp=new SetVideoProperties();
		svp.setProperties(props);
		Marshaller m= new Marshaller();
		
		try {
			String cmd=PREFIX+m.marshall(svp);
			System.out.println(cmd);
			Request rq = new Request.Builder()
					.url(cmd)
					.addHeader("Authorization", content).build();
			Response r = client.newCall(rq).execute();
			System.out.println(r.body().string());
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void get() {
		System.out.println("running sync get");
		OkHttpClient client = new OkHttpClient();
		String auth = "admin:admin";
		byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
		String content = "Basic " + new String(encoded);
		System.out.println(content);
		GetVideoEncoderProperties gvep=new GetVideoEncoderProperties();
		gvep.setStreamID(StreamID.Sub);
		Marshaller m= new Marshaller();
		Unmarshaller um=new Unmarshaller();
		
		try {
			String cmd=PREFIX+m.marshall(gvep);
			System.out.println(cmd);
			Request rq = new Request.Builder()
					.url(cmd)
					.addHeader("Authorization", content).build();
			Response r = client.newCall(rq).execute();
			try {
				um.unmarshall(r.body().charStream(),VideoEncoderProperties.class);
			} catch (UnmarshallException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			BufferedReader reader=new BufferedReader(r.body().charStream());			
//			String line=null;
//			while ((line=reader.readLine())!=null) {
//				System.out.println(line);
//			}
//			System.out.println(response.split("\n").length);
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
