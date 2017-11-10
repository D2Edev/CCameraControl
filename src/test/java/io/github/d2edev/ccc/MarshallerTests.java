package io.github.d2edev.ccc;


import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.enums.ImageQuality;
import io.github.d2edev.ccc.enums.RateControl;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.SetVideoEncoderProperties;

public class MarshallerTests {

	private static final String PREFIX = "http://192.168.0.201/cgi-bin/hi3510/param.cgi?";

	public static void main(String[] args) {
		new MarshallerTests().set();
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
