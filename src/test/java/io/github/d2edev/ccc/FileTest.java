package io.github.d2edev.ccc;

import java.io.FileOutputStream;
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
import io.github.d2edev.ccc.requests.system.GetServerTime;
import io.github.d2edev.ccc.requests.system.SetServerTime;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import okhttp3.Response;

public class FileTest {

	private static final String IP = "192.168.0.212";

	public static void main(String[] args) {
		IPCamera cam=new IPCamera(IP, IPCamera.DEFAULT_HTTP_PORT, "admin", "admin");
		try {
			byte []data=cam.getSystemService().getBackupData();
			System.out.println(data.length);
			try (FileOutputStream fileOuputStream = new FileOutputStream("backup.bin")) {
	            fileOuputStream.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
