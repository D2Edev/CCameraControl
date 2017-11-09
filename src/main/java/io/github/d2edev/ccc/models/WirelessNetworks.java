package io.github.d2edev.ccc.models;

import java.util.List;

import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.SetModel;

@ModelType(ModelType.NETWORKLIST)
public class WirelessNetworks {
	
	private List<WirelessProperties> networks;
	
	@GetModel
	public List<WirelessProperties> getNetworks() {
		return networks;
	}

	@SetModel
	public void setNetworks(List<WirelessProperties> networks) {
		this.networks = networks;
	}
	
	

}
