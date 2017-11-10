package io.github.d2edev.ccc.requests.system;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.ServerInfo;

@Request("getserverinfo")
public class GetServerInfo implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return ServerInfo.class;
	}

}
