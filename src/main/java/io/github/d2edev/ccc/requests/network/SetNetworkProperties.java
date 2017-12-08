package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.NetworkProperties;

@Request("setnetattr")
public class SetNetworkProperties{
	
	private NetworkProperties properties;

	@GetModel
	public NetworkProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(NetworkProperties properties) {
		this.properties = properties;
	}

	
	

}
