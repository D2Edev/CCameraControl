package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.ServerTime;

@Request("getservertime")
public class GetServerTime implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return ServerTime.class;
	}

}
