package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.models.OSDProperties;

@CamRequest(cmd="setoverlayattr")
public class SetOverlayProperties extends AbstractCamRequest{
	
	private OSDRegion region;
	
	private OSDProperties properties;
	
	{command="setoverlayattr";}

	@GetModelValue(key="region")
	public OSDRegion getRegion() {
		return region;
	}

	public void setRegion(OSDRegion region) {
		this.region = region;
	}

	@GetModel
	public OSDProperties getProperties() {
		return properties;
	}

	public void setProperties(OSDProperties properties) {
		this.properties = properties;
	}
	
	

}
