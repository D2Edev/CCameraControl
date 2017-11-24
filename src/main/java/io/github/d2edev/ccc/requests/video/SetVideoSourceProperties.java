package io.github.d2edev.ccc.requests.video;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoSourceProperties;

@Request("setvideoattr")
public class SetVideoSourceProperties{
	
	private VideoSourceProperties properties;

	@GetModel
	public VideoSourceProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(VideoSourceProperties properties) {
		this.properties = properties;
	}

	

}
