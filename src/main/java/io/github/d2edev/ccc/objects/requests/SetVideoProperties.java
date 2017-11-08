package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.base.QuerySet;
import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.models.SimpleResponse;
import io.github.d2edev.ccc.objects.models.VideoProperties;

@QueryCommand("setvideoattr")
public class SetVideoProperties implements CameraRequest{
	
	@QuerySet
	private VideoProperties properties;

	public VideoProperties getProperties() {
		return properties;
	}

	public void setProperties(VideoProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}
	
	

}
