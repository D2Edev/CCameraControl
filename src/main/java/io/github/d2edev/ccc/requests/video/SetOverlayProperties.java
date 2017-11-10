package io.github.d2edev.ccc.requests.video;

import io.github.d2edev.ccc.api.CameraRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.models.OverlayProperties;
import io.github.d2edev.ccc.models.SimpleResponse;

@Request("setoverlayattr")
public class SetOverlayProperties implements CameraRequest{
	
	private OSDRegion region;
	
	private OverlayProperties properties;

	@GetModelValue(key="region")
	public OSDRegion getRegion() {
		return region;
	}

	public void setRegion(OSDRegion region) {
		this.region = region;
	}

	@GetModel
	public OverlayProperties getProperties() {
		return properties;
	}

	public void setProperties(OverlayProperties properties) {
		this.properties = properties;
	}

	@Override
	public Class<?> getExpectedResponseType() {
		return SimpleResponse.class;
	}
	
	

}
