package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.SetModelValue;
import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.support.StreamID;

@Request("getvencattr")
public class GetVideoEncoderProperties implements CameraRequest{
	
	private StreamID streamID;	
	
	
	@SetModelValue(key="chn")
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	@GetModelValue(key="chn")
	public StreamID getStreamID() {
		return streamID;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return VideoEncoderProperties.class;
	}
	

}
