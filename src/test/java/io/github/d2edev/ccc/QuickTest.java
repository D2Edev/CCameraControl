package io.github.d2edev.ccc;


import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.base.StringMarshaller;
import io.github.d2edev.ccc.enums.ImageQuality;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.RateControl;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.OSDProperties;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import io.github.d2edev.ccc.requests.video.SetOverlayProperties;
import io.github.d2edev.ccc.requests.video.SetVideoEncoderProperties;
import io.github.d2edev.ccc.services.SystemService;

public class QuickTest {

	private static final String IP = "192.168.0.212";

	public static void main(String[] args) {
//		new QuickTest().set();
		new QuickTest().setCaption();
	}

	private void time() {
		try {
			IPCamera camera=new IPCamera(IP, 80, "admin", "admin");
			SystemService service=camera.getSystemService();
			ServerTime time=service.getServerTime();
//			time.setDateTime(new Date());
//			time.setTimeZone(CameraTimeZone.EUROPE_ATHENS);
//			service.setServerTime(time);
			System.out.println(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void setCaption() {
		try {
			CameraHttpClient c=new CameraHttpClient(IP, IPCamera.DEFAULT_HTTP_PORT, "admin", "admin");
			GetOverlayProperties get=new GetOverlayProperties();
			get.setRegion(OSDRegion.CAPTION);
			OSDProperties props=c.processRequest(get, OSDProperties.class);
			props.setName("DFGH");
			SetOverlayProperties set=new SetOverlayProperties();
			set.setProperties(props);
			set.setRegion(OSDRegion.CAPTION);
			System.out.println(c.processRequest(set).body().string());
			
			
			
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
		StringMarshaller m = new StringMarshaller();
		try {
			String result=m.marshall(sp);
			System.out.println(result);
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
