package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.NetworkProperties;

@CamRequest(cmd="setnetattr")
public class SetNetworkProperties extends AbstractCamRequest{
	
	private NetworkProperties properties;
	{command="setnetattr";}
	
	@GetModel
	public NetworkProperties getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(NetworkProperties properties) {
		this.properties = properties;
	}

	
	

}
