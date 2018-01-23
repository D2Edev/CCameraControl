package io.github.d2edev.ccc.requests.network;


import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.CamRequest;
import io.github.d2edev.ccc.api.SetModel;
import io.github.d2edev.ccc.models.WirelessNetwork;

@CamRequest(cmd="setwirelessattr")
public class SetWirelessProperties extends AbstractCamRequest{
	
	private WirelessNetwork properties;
	{command="setwirelessattr";}
	
	@GetModel
	public WirelessNetwork getProperties() {
		return properties;
	}

	@SetModel
	public void setProperties(WirelessNetwork properties) {
		this.properties = properties;
	}

}
