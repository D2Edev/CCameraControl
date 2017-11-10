package io.github.d2edev.ccc.requests.video;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.models.VideoSourceProperties;

@Request("getvideoattr")
public class GetVideoSourceProperties implements CameraRequest {

	@Override
	public Class<?> getExpectedResponseType() {
		return VideoSourceProperties.class;
	}

}
