package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.NetworkProperties;
import io.github.d2edev.ccc.models.SimpleResponse;

@Request("setnetattr")
public class SetNetworkProperties implements CameraRequest{
	
	private NetworkProperties properties;

	@GetModel
	public NetworkProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(NetworkProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}
	
	

}
