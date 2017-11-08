package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.base.QuerySet;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.support.StreamID;

@QueryCommand("setvencattr")
public class SetVideoEncoderProperties implements CameraRequest{
	
	@QueryParameter(get = "chn")
	private StreamID streamID;
	
	@QuerySet
	private VideoEncoderProperties properties;
	
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	public StreamID getStreamID() {
		return streamID;
	}

	public VideoEncoderProperties getProperties() {
		return properties;
	}

	public void setProperties(VideoEncoderProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}


	
	

}
