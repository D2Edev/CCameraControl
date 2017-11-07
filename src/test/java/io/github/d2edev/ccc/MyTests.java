package io.github.d2edev.ccc;

import io.github.d2edev.ccc.objects.models.VideoProperties;
import io.github.d2edev.ccc.objects.requests.SetVideoProperties;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.VideoMode;
import io.github.d2edev.ccc.util.MarshallException;
import io.github.d2edev.ccc.util.Marshaller;

public class MyTests {
	public static void main(String[] args) {
//		GetVideoProperties gva=new GetVideoProperties();
		VideoProperties props=new VideoProperties();
		props.setFormat(TVFormat.PAL);
		props.setProfile(H264profile.BASELINE);
		props.setVideoMode(VideoMode._1280x720_640x352);
		SetVideoProperties svp=new SetVideoProperties();
		svp.setProperties(props);
		Marshaller m= new Marshaller();
		try {
			System.out.println(m.marshall(svp));
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
