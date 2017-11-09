package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.VideoProperties;

@Request("getvideoattr")
public class GetVideoProperties implements CameraRequest {

	@Override
	public Class<?> getExpectedResponseType() {
		return VideoProperties.class;
	}

}
