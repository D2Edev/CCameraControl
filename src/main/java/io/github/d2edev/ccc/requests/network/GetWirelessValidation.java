package io.github.d2edev.ccc.requests.network;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.WirelessValidationResult;

@Request("getchkwireless")
public class GetWirelessValidation implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		// TODO Auto-generated method stub
		return WirelessValidationResult.class;
	}

}
