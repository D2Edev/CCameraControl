package io.github.d2edev.ccc.objects.models;

import java.util.List;

import io.github.d2edev.ccc.objects.base.GetModel;
import io.github.d2edev.ccc.objects.base.ModelType;
import io.github.d2edev.ccc.objects.base.SetModel;

@ModelType(ModelType.DYNAMIC)
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
