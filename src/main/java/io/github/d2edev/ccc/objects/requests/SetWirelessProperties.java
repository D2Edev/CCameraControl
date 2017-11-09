package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.SetModel;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.WirelessProperties;

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
