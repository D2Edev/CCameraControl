package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.Request;
import io.github.d2edev.ccc.objects.base.SetModel;
import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.VideoProperties;

@Request("setvideoattr")
public class SetVideoProperties implements CameraRequest{
	
	private VideoProperties properties;

	@GetModel
	public VideoProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(VideoProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}
	
	

}
