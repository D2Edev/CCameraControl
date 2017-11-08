package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QuerySet;
import io.github.d2edev.ccc.objects.models.ServerTime;
import io.github.d2edev.ccc.objects.models.SimpleResponse;

@QueryCommand("setservertime")
public class SetServerTime implements CameraRequest{

	@QuerySet
	private ServerTime serverTime;
		
	public ServerTime getServerTime() {
		return serverTime;
	}

	public void setServerTime(ServerTime serverTime) {
		this.serverTime = serverTime;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}

}
