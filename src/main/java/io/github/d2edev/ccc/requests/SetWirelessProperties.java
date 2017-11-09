package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.WirelessProperties;

@Request("setwirelessattr")
public class SetWirelessProperties implements CameraRequest{
	
	private WirelessProperties properties;

	@GetModel
	public WirelessProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(WirelessProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}

}
