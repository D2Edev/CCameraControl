package io.github.d2edev.ccc;

import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.base.Unmarshaller;
import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.State;
import io.github.d2edev.ccc.enums.Status;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.enums.TVFormat;
import io.github.d2edev.ccc.enums.VideoMode;
import io.github.d2edev.ccc.enums.WiFiKeyEncoding;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.models.VideoProperties;
import io.github.d2edev.ccc.models.WirelessProperties;
import io.github.d2edev.ccc.requests.GetConnectedUsersNumber;
import io.github.d2edev.ccc.requests.GetDeviceType;
import io.github.d2edev.ccc.requests.GetServerInfo;
import io.github.d2edev.ccc.requests.GetServerTime;
import io.github.d2edev.ccc.requests.GetVideoEncoderProperties;
import io.github.d2edev.ccc.requests.GetVideoProperties;
import io.github.d2edev.ccc.requests.GetWirelessNetworks;
import io.github.d2edev.ccc.requests.GetWirelessProperties;
import io.github.d2edev.ccc.requests.SetServerTime;
import io.github.d2edev.ccc.requests.SetVideoProperties;
import io.github.d2edev.ccc.requests.SetWirelessProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpTest {

	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.201/" + ENDPOINT + "?";

	public static void main(String[] args) {
		HttpTest test = new HttpTest();
		 CameraRequest r=new GetWirelessNetworks();
		 test.processForString(r);
		// test.processForObject(r);
//		test.processGetSetWifi();

	}

	public void processGetSetTime() {
		CameraHttpClient client = new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			GetServerTime request = new GetServerTime();
			ServerTime time = (ServerTime) client.processRequest(request, request.getExpectedResponseType());
			System.out.println("reply: " + time);
			SetServerTime set = new SetServerTime();
			time.setTimeZone(CameraTimeZone.AMERICA_NEWYORK);
			time.setDaylightModeStatus(Status.OFF);
			// time.setTime("19911107061052");
			set.setServerTime(time);
			System.out.println("setting: " + time);
			System.out.println(client.processRequest(set, set.getExpectedResponseType()));
			time = (ServerTime) client.processRequest(request, request.getExpectedResponseType());
			System.out.println("check:" + time);
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processGetSetWifi() {
		CameraHttpClient client = new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			GetWirelessProperties request = new GetWirelessProperties();
			WirelessProperties props = (WirelessProperties) client.processRequest(request,
					request.getExpectedResponseType());
			System.out.println("reply: " + props);
			SetWirelessProperties set = new SetWirelessProperties();
			props.setPassphrase("my_passw0rd");
			props.setSSID("MySuperAP");
			props.setState(State.ON);
			props.setKeyEncoding(WiFiKeyEncoding.AES);
			set.setProperties(props);
			System.out.println("setting: " + props);
			System.out.println(client.processRequest(set, set.getExpectedResponseType()));
			props = (WirelessProperties) client.processRequest(request, request.getExpectedResponseType());
			System.out.println("check:" + props);
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processForObject(CameraRequest obj) {
		CameraHttpClient client = new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(obj, obj.getExpectedResponseType()));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processForString(Object obj) {
		CameraHttpClient client = new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(obj));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
