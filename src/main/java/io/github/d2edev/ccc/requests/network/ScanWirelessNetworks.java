package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.WirelessNetworks;

@Request("searchwireless")
public class ScanWirelessNetworks implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return WirelessNetworks.class;
	}

}
