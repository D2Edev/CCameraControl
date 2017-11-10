package io.github.d2edev.ccc.requests.video;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.DeviceType;
import io.github.d2edev.ccc.models.ImageProperties;

@Request("getimageattr")
public class GetImageProperties implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return ImageProperties.class;
	}

}
