package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoEncoderProperties;

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
