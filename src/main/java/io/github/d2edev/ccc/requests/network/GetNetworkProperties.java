package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.NetworkProperties;

@Request("getnetattr")
public class GetNetworkProperties implements CameraRequest {

	@Override
	public Class<?> getExpectedResponseType() {
		return NetworkProperties.class;
	}

}
