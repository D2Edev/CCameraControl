package io.github.d2edev.ccc;


import java.time.ZoneId;
import java.time.ZonedDateTime;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.ImageQuality;
import io.github.d2edev.ccc.enums.RateControl;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.SetVideoEncoderProperties;
import io.github.d2edev.ccc.services.SystemService;

public class QuickTest {

	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";

	public static void main(String[] args) {
//		new QuickTest().set();
		new QuickTest().time();
	}

	private void time() {
		try {
			IPCamera camera=new IPCamera("192.168.43.20", 80, ENDPOINT, "admin", "admin");
			SystemService service=camera.getSystemService();
			ServerTime time=service.getServerTime();
			time.setDaylightModeStatus(StringState.ENABLED);
			ZoneId zid=ZoneId.of(CameraTimeZone.EUROPE_MOSCOW.stringValue());
			ZonedDateTime zdt=ZonedDateTime.now(zid);
			time.setDateTime(zdt);
			ServerTime changed= service.getServerTime();
			System.out.println("check:" + changed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// @Test
	public void set() {
		System.out.println("Marshaller test");
		VideoEncoderProperties p = new VideoEncoderProperties();
		p.setBps(512);
		p.setFps(10);
		p.setGop(20);
		p.setQuality(ImageQuality.BEST);
		p.setRateControl(RateControl.FIXED);
		SetVideoEncoderProperties sp=new SetVideoEncoderProperties();
		sp.setProperties(p);
		sp.setStreamID(StreamID.Main);
		Marshaller m = new Marshaller();
		try {
			String result=m.marshall(sp);
			System.out.println(result);
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
