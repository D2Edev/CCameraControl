package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.OSDRegion;

@CamRequest(cmd="getoverlayattr")
public class GetOverlayProperties extends AbstractCamRequest{
	private OSDRegion region;
	
	{command="getoverlayattr";}
	
	
	@GetModelValue(key="region")
	public OSDRegion getRegion() {
		return region;
	}

	@SetModelValue(key="region")
	public void setRegion(OSDRegion region) {
		this.region = region;
	}

}
