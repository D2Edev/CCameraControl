package io.github.d2edev.ccc.requests.system;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.DeviceType;

@Request("getdevtype")
public class GetDeviceType implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return DeviceType.class;
	}

}
