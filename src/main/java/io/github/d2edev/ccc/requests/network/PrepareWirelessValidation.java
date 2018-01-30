package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.WirelessNetwork;

@CamRequest(cmd="chkwirelessattr")
public class PrepareWirelessValidation extends AbstractCamRequest{
	
	private WirelessNetwork network;
	
	{command="chkwirelessattr";}

	@GetModel
	public WirelessNetwork getNetwork() {
		return network;
	}

	@SetModel
	public void setNetwork(WirelessNetwork network) {
		this.network = network;
	}
	

}
