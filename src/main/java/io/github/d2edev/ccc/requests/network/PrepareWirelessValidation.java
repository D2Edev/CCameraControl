package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Request;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.WirelessNetwork;

@Request("chkwirelessattr")
public class PrepareWirelessValidation{
	
	private WirelessNetwork network;

	@GetModel
	public WirelessNetwork getNetwork() {
		return network;
	}

	@SetModel
	public void setNetwork(WirelessNetwork network) {
		this.network = network;
	}
	

}
