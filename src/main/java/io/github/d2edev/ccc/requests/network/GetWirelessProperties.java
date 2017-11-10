package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.WirelessProperties;

@Request("getwirelessattr")
public class GetWirelessProperties implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return null;
	}

}
