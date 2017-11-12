package io.github.d2edev.ccc.services;

import java.io.IOException;
import java.util.List;

import io.github.d2edev.ccc.api.AbstractService;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.models.WirelessNetworks;
import io.github.d2edev.ccc.requests.network.ScanWirelessNetworks;
import io.github.d2edev.ccc.requests.network.SetWirelessProperties;
import io.github.d2edev.ccc.requests.network.GetWirelessProperties;

public class NetworkService extends AbstractService{

	public NetworkService(CameraHttpClient client) {
		super(client);

	}
	
	public List<WirelessNetwork> scanWirelessNetworks() throws MarshallException, IOException, UnmarshallException{
		ScanWirelessNetworks request=new ScanWirelessNetworks();
		WirelessNetworks nets= (WirelessNetworks)client.processRequest(request, request.getExpectedResponseType());
		return nets.getNetworks();
	}

	public WirelessNetwork getWirelessSettings() throws MarshallException, IOException, UnmarshallException {
		GetWirelessProperties request=new GetWirelessProperties();
		return (WirelessNetwork)client.processRequest(request, request.getExpectedResponseType());
	}

	public boolean setWirelessNetwork(WirelessNetwork net) throws MarshallException, IOException, UnmarshallException {
		SetWirelessProperties request=new SetWirelessProperties();
		request.setProperties(net);
		SimpleResponse response=(SimpleResponse) client.processRequest(request, request.getExpectedResponseType());
		return response.isSuccessfull();
	}
	
}