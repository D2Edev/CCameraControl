package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.VideoEncoderProperties;

@Request("getvencattr")
public class GetVideoEncoderProperties{
	
	private StreamID streamID;	
	
	
	@SetModelValue(key="chn")
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	@GetModelValue(key="chn")
	public StreamID getStreamID() {
		return streamID;
	}

	

}
