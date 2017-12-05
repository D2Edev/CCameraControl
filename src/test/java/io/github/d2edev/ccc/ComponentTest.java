package io.github.d2edev.ccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.base.Unmarshaller;
import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.enums.TVFormat;
import io.github.d2edev.ccc.enums.VideoOptimization;
import io.github.d2edev.ccc.enums.WifiKeyEncryption;
import io.github.d2edev.ccc.models.ImageProperties;
import io.github.d2edev.ccc.models.NetworkProperties;
import io.github.d2edev.ccc.models.OSDProperties;
import io.github.d2edev.ccc.models.RTSPPort;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.models.VideoSourceProperties;
import io.github.d2edev.ccc.models.WirelessNetworks;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.requests.network.ScanWirelessNetworks;
import io.github.d2edev.ccc.requests.network.GetNetworkProperties;
import io.github.d2edev.ccc.requests.network.GetRTSPPort;
import io.github.d2edev.ccc.requests.network.GetWirelessProperties;
import io.github.d2edev.ccc.requests.network.SetWirelessProperties;
import io.github.d2edev.ccc.requests.system.GetActiveStreamsQ;
import io.github.d2edev.ccc.requests.system.GetDeviceType;
import io.github.d2edev.ccc.requests.system.GetServerInfo;
import io.github.d2edev.ccc.requests.system.GetServerTime;
import io.github.d2edev.ccc.requests.system.SetServerTime;
import io.github.d2edev.ccc.requests.video.GetImageProperties;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import io.github.d2edev.ccc.requests.video.GetVideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.GetVideoSourceProperties;
import io.github.d2edev.ccc.requests.video.SetImageProperties;
import io.github.d2edev.ccc.requests.video.SetOverlayProperties;
import io.github.d2edev.ccc.requests.video.SetVideoSourceProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ComponentTest {

	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private static final String PREFIX = "http://192.168.0.211/" + ENDPOINT + "?";

	public static void main(String[] args) {
		ComponentTest cp = new ComponentTest();
		GetRTSPPort grp = new GetRTSPPort();
		Object req = grp;
		cp.processForString(req);
		cp.processForObject(req, RTSPPort.class);

	}

	public void processForObject(Object request, Class<?> respClass) {
		CameraHttpClient client = new CameraHttpClient("192.168.0.211", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(request, respClass));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processForString(Object obj) {
		CameraHttpClient client = new CameraHttpClient("192.168.0.211", 80, "admin", "admin", ENDPOINT);
		try {
			System.out.println(client.processRequest(obj));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processGetSetTime() {
		CameraHttpClient client = new CameraHttpClient("192.168.0.201", 80, "admin", "admin", ENDPOINT);
		try {
			GetServerTime request = new GetServerTime();
			ServerTime time = client.processRequest(request, ServerTime.class);
			System.out.println("reply: " + time);
			SetServerTime set = new SetServerTime();
			time.setTimeZone(CameraTimeZone.AMERICA_NEWYORK.stringValue());
			time.setDaylightModeStatus(StringState.DISABLED);
			// time.setTime("19911107061052");
			time.setDateTime(ZonedDateTime.now(ZoneId.of(time.getTimeZone())));
			set.setServerTime(time);
			System.out.println("setting: " + time);
			System.out.println(client.processRequest(set, SimpleResponse.class));
			time = client.processRequest(request, ServerTime.class);
			System.out.println("check:" + time);
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
