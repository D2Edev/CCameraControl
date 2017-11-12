package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.WirelessNetwork;

@Request("setwirelessattr")
public class SetWirelessProperties implements CameraRequest{
	
	private WirelessNetwork properties;

	@GetModel
	public WirelessNetwork getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(WirelessNetwork properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}

}
