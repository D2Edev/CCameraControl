package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.SetModel;
import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.models.ServerTime;
import io.github.d2edev.ccc.objects.models.SimpleResponse;

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
