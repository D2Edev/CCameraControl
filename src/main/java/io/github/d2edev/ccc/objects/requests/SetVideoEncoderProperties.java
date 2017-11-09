package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.SetModel;
import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.SetModelValue;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.VideoEncoderProperties;
import io.github.d2edev.ccc.objects.support.StreamID;

@Request("setvencattr")
public class SetVideoEncoderProperties implements CameraRequest{
	
	private StreamID streamID;
	
	private VideoEncoderProperties properties;
	
	@SetModelValue(key="chn")
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	@GetModelValue(key="chn")
	public StreamID getStreamID() {
		return streamID;
	}

	@GetModel
	public VideoEncoderProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(VideoEncoderProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}


	
	

}
