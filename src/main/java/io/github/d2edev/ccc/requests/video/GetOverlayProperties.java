package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.OSDRegion;

@Request("getoverlayattr")
public class GetOverlayProperties{
	
	private OSDRegion region;
	
	
	
	@GetModelValue(key="region")
	public OSDRegion getRegion() {
		return region;
	}

	@SetModelValue(key="region")
	public void setRegion(OSDRegion region) {
		this.region = region;
	}

}
