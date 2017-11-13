package io.github.d2edev.ccc;

import java.util.Date;

import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.services.SystemService;

public class Sample {
	
	public static void main(String[] args) {
		final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
		try {
			IPCamera camera = new IPCamera("192.168.0.201", 80, ENDPOINT, "admin", "admin");
			SystemService service=camera.getSystemService();
			ServerTime time = service.getServerTime();
			System.out.println("reply: " + time);
			time.setTimeZone(CameraTimeZone.AMERICA_NEWYORK);
			time.setDaylightModeStatus(StringState.DISABLED);
			time.setDateTime(new Date());
			service.setServerTime(time);
			ServerTime changed= service.getServerTime();
			System.out.println("check:" + changed);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
