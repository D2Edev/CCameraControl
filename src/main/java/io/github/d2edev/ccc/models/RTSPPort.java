package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;

@Model(Model.COMPLEX)
public class RTSPPort {
	
	private int rtspPort;
	private int rtpPort;

	@GetModelValue(key = "rtspport")
	public int getRTSPport() {
		return rtspPort;
	}

	@SetModelValue(key = "rtspport")
	public void setRTSPport(int port) {
		this.rtspPort = port;
	}

	public int getRTPport() {
		return rtpPort;
	}
	
	@SetModelValue(key = "rtpport")
	public void setRTPort(int rtpPort) {
		this.rtpPort = rtpPort;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RTSPPort [rtspPort=");
		builder.append(rtspPort);
		builder.append(", rtpPort=");
		builder.append(rtpPort);
		builder.append("]");
		return builder.toString();
	}
	

}
