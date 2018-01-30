package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.ImageProperties;

@CamRequest(cmd="setimageattr")
public class SetImageProperties extends AbstractCamRequest{
	
	private ImageProperties properties;

	{command="setimageattr";}
	
	@GetModel
	public ImageProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(ImageProperties properties) {
		this.properties = properties;
	}
	
	

}
