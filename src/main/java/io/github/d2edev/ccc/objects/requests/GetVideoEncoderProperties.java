package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.support.StreamID;

@QueryCommand("getvencattr")
public class GetVideoEncoderProperties implements CameraRequest{
	
	@QueryParameter(get = "chn")
	private StreamID streamID;	
	
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	public StreamID getStreamID() {
		return streamID;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return VideoEncoderProperties.class;
	}
	

}
