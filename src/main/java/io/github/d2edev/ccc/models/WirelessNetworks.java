package io.github.d2edev.ccc.models;

import java.util.List;

import io.github.d2edev.ccc.api.GetModel;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModel;

@Model(Model.NETWORKLIST)
public class WirelessNetworks {
	// reply example:
	// var waccess_points="2" ;
	// var wchannel=new Array();
	// var wrssi=new Array();
	// var wessid=new Array();
	// var wenc=new Array();
	// var wauth=new Array();
	// var wnet=new Array();
	// wchannel[0]="6" ;
	// wrssi[0]="-82" ;
	// wessid[0]="Fumax wireless" ;
	// wenc[0]="AES" ;
	// wauth[0]="WPA(2)-PSK" ;
	// wnet[0]="Infra" ;
	// wchannel[1]="11" ;
	// wrssi[1]="-62" ;
	// wessid[1]="linksys" ;
	// wenc[1]="TKIP" ;
	// wauth[1]="WPA(2)-PSK" ;
	// wnet[1]="Infra" ;

	private List<WirelessNetwork> networks;

	@GetModel
	public List<WirelessNetwork> getNetworks() {
		return networks;
	}

	@SetModel
	public void setNetworks(List<WirelessNetwork> networks) {
		this.networks = networks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Networks:");
		if(networks==null||networks.size()<1){
			builder.append("[none]");
		}
		;
		for (WirelessNetwork wirelessNetwork : networks) {
			builder.append("\n").append(wirelessNetwork);
		}
		return builder.toString();
	}

	
}
