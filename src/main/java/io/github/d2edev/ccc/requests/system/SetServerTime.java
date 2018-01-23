package io.github.d2edev.ccc.requests.system;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.ServerTime;

@CamRequest(cmd="setservertime")
public class SetServerTime extends AbstractCamRequest{

	private ServerTime serverTime;
	
	{command="setservertime";}
	
	@GetModel
	public ServerTime getServerTime() {
		return serverTime;
	}

	@SetModel
	public void setServerTime(ServerTime serverTime) {
		this.serverTime = serverTime;
	}

}
