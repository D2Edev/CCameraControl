package io.github.d2edev.ccc;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.models.RTSPPort;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.requests.network.GetRTSPPort;
import io.github.d2edev.ccc.requests.system.MakeBackup;
import io.github.d2edev.ccc.requests.system.MakeRestore;
import io.github.d2edev.ccc.requests.system.GetServerTime;
import io.github.d2edev.ccc.requests.system.SetServerTime;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import okhttp3.Response;

public class ComponentTest {

	private static final String IP = "192.168.0.212";

	public static void main(String[] args) {
		ComponentTest cp = new ComponentTest();
//		GetRTSPPort grp = new GetRTSPPort();
//		GetOverlayProperties gop=new GetOverlayProperties();
//		gop.setRegion(OSDRegion.CAPTION);
//		SettingsBackup gbd=new SettingsBackup();
		MakeRestore r=new MakeRestore();
		r.setBackupFilePath(new File("backup.bin"));
		AbstractCamRequest req = r;
//		cp.processForString(req);
		cp.processForObject(req, SimpleResponse.class);
	}

	public void processForObject(AbstractCamRequest request, Class<?> respClass) {
		CameraHttpClient client = new CameraHttpClient(IP, 80, "admin", "admin");
		try {
			System.out.println(client.processRequest(request, respClass));
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processForString(AbstractCamRequest obj) {
		CameraHttpClient client = new CameraHttpClient(IP, 80, "admin", "admin");
		try {
			Response r=client.processRequest(obj);
			
			System.out.println(r.body().string());
		} catch (MarshallException | IOException | UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processGetSetTime() {
		CameraHttpClient client = new CameraHttpClient(IP, 80, "admin", "admin");
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
