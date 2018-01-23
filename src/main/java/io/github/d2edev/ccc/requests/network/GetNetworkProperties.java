package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;

@CamRequest(cmd="getnetattr")
public class GetNetworkProperties  extends AbstractCamRequest{
	
	{
		command="getnetattr";
	}

}
