package io.github.d2edev.ccc;

import java.io.IOException;
import java.util.Base64;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.ServerTime;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.models.VideoProperties;
import io.github.d2edev.ccc.objects.requests.GetConnectedUsersNumber;
import io.github.d2edev.ccc.objects.requests.GetDeviceType;
import io.github.d2edev.ccc.objects.requests.GetServerInfo;
import io.github.d2edev.ccc.objects.requests.GetServerTime;
import io.github.d2edev.ccc.objects.requests.GetVideoEncoderProperties;
import io.github.d2edev.ccc.objects.requests.GetVideoProperties;
import io.github.d2edev.ccc.objects.requests.GetWirelessProperties;
import io.github.d2edev.ccc.objects.requests.SetServerTime;
import io.github.d2edev.ccc.objects.requests.SetVideoProperties;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.Status;
import io.github.d2edev.ccc.objects.support.StreamID;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.TimeZone;
import io.github.d2edev.ccc.objects.support.VideoMode;
import io.github.d2edev.ccc.util.CameraHttpClient;
import io.github.d2edev.ccc.util.MarshallException;
import io.github.d2edev.ccc.util.Marshaller;
import io.github.d2edev.ccc.util.UnmarshallException;
import io.github.d2edev.ccc.util.Unmarshaller;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpTest {

	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.201/"+ENDPOINT+"?";

	public static void main(String[] args) {
		CameraRequest r=new GetWirelessProperties();
		HttpTest test=new HttpTest();
		test.processForString(r);
		test.processForObject(r);
//		test.processGetSet();
		
	}


	public void processGetSet() {
		CameraHttpClient client=new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			GetServerTime request=new GetServerTime();
			ServerTime time=(ServerTime)client.processRequest(request,request.getExpectedResponseType());
			System.out.println(time);
			SetServerTime set=new SetServerTime();
			time.setTimeZone(TimeZone.EUROPE_ATHENS);
			time.setDaylightModeStatus(Status.OFF);
			set.setServerTime(time);
			System.out.println(client.processRequest(set, set.getExpectedResponseType()));
			System.out.println(client.processRequest(set, set.getExpectedResponseType()));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void processForObject(CameraRequest obj) {
		CameraHttpClient client=new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(obj,obj.getExpectedResponseType()));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processForString(Object obj) {
		CameraHttpClient client=new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(obj));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
