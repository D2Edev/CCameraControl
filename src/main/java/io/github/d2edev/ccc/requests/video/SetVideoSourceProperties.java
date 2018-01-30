package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.VideoSourceProperties;

@CamRequest(cmd="setvideoattr")
public class SetVideoSourceProperties extends AbstractCamRequest{
	
	private VideoSourceProperties properties;

	{command="setvideoattr";}
	
	@GetModel
	public VideoSourceProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(VideoSourceProperties properties) {
		this.properties = properties;
	}

	

}
