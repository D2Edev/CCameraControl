package io.github.d2edev.ccc;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.base.Marshaller;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.TVFormat;
import io.github.d2edev.ccc.enums.VideoMode;
import io.github.d2edev.ccc.models.VideoProperties;
import io.github.d2edev.ccc.requests.SetVideoProperties;

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
