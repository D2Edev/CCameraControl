package io.github.d2edev.ccc;


import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.requests.SetVideoEncoderProperties;
import io.github.d2edev.ccc.objects.support.ImageQuality;
import io.github.d2edev.ccc.objects.support.RateControl;
import io.github.d2edev.ccc.objects.support.StreamID;
import io.github.d2edev.ccc.util.MarshallException;
import io.github.d2edev.ccc.util.Marshaller;

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
