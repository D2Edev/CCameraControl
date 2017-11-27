package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;

@Model(Model.COMPLEX)
public class RTSPPort {
	
	private int port;

	@GetModelValue(key = "rtspport")
	public int getPort() {
		return port;
	}

	@SetModelValue(key = "rtspport")
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
