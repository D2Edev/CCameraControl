package io.github.d2edev.ccc.requests;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoProperties;

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
