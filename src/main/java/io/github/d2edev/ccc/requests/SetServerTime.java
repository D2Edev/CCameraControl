package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.SimpleResponse;

@Request("setservertime")
public class SetServerTime implements CameraRequest{

	private ServerTime serverTime;
		
	@GetModel
	public ServerTime getServerTime() {
		return serverTime;
	}

	@SetModel
	public void setServerTime(ServerTime serverTime) {
		this.serverTime = serverTime;
	}

	
	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}

}
