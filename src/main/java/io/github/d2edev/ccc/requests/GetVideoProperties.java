package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.VideoProperties;

@Request("getvideoattr")
public class GetVideoProperties implements CameraRequest {

	@Override
	public Class<?> getExpectedResponseType() {
		return VideoProperties.class;
	}

}
