package io.github.d2edev.ccc;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.services.SystemService;

public class Sample {
	
	public static void main(String[] args) {
		final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
		try {
			IPCamera camera = new IPCamera("192.168.0.210", 80, ENDPOINT, "admin", "admin");
			SystemService service=camera.getSystemService();
			ServerTime time = service.getServerTime();
			System.out.println("reply: " + time.toString());
			ZonedDateTime zdt=time.getDateTime();
			zdt=zdt.withZoneSameInstant(ZoneId.of(CameraTimeZone.AMERICA_NEWYORK.stringValue()));
			time.setDaylightModeStatus(StringState.DISABLED);
			time.setDateTime(zdt);
			System.out.println("new: " + time);
			service.setServerTime(time);
			ServerTime changed= service.getServerTime();
			System.out.println("check:" + changed);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
