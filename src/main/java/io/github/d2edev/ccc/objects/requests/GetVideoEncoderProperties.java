package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.StreamID;

@QueryCommand("getvencattr")
public class GetVideoEncoderProperties {
	
	@QueryParameter("chn")
	private StreamID streamID;	
	
	public void setStreamID(StreamID streamID) {
		this.streamID = streamID;
	}
	
	public StreamID getStreamID() {
		return streamID;
	}
	

}
