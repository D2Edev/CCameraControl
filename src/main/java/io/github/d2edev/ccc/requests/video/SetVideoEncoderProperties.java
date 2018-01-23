package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.VideoEncoderProperties;

@CamRequest(cmd="setvencattr")
public class SetVideoEncoderProperties extends AbstractCamRequest{
	
	private StreamID streamID;
	
	private VideoEncoderProperties properties;
	
	{command="setvencattr";}
	
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

}
