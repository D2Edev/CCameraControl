package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.WirelessProperties;

@Request("searchwireless")
public class GetWirelessNetworks implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return WirelessProperties.class;
	}

}
