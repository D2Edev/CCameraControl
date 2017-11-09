package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.models.DeviceType;

@Request("getdevtype")
public class GetDeviceType implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return DeviceType.class;
	}

}
