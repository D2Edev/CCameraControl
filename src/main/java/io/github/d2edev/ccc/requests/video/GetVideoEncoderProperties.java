package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.StreamID;

@CamRequest(cmd="getvencattr")
public class GetVideoEncoderProperties extends AbstractCamRequest{
	
	private StreamID streamID;	
	{command="getvencattr";}
	
	@SetModelValue(key="chn")
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	@GetModelValue(key="chn")
	public StreamID getStreamID() {
		return streamID;
	}

	

}
