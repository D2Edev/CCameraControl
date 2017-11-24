package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.ImageProperties;
import io.github.d2edev.ccc.models.SimpleResponse;

@Request("setimageattr")
public class SetImageProperties{
	
	private ImageProperties properties;

	@GetModel
	public ImageProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(ImageProperties properties) {
		this.properties = properties;
	}
	
	

}
