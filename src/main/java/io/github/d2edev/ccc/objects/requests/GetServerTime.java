package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.models.ServerTime;

@Request("getservertime")
public class GetServerTime implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return ServerTime.class;
	}

}
