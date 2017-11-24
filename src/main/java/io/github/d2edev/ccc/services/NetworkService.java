package io.github.d2edev.ccc.services;

import java.io.IOException;
import java.util.List;

import io.github.d2edev.ccc.api.AbstractService;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.models.NetworkProperties;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.models.WirelessNetworks;
import io.github.d2edev.ccc.models.WirelessValidationResult;
import io.github.d2edev.ccc.requests.network.ScanWirelessNetworks;
import io.github.d2edev.ccc.requests.network.SetNetworkProperties;
import io.github.d2edev.ccc.requests.network.SetWirelessProperties;
import io.github.d2edev.ccc.requests.network.GetNetworkProperties;
import io.github.d2edev.ccc.requests.network.GetWirelessProperties;
import io.github.d2edev.ccc.requests.network.GetWirelessValidation;
import io.github.d2edev.ccc.requests.network.PrepareWirelessValidation;

public class NetworkService extends AbstractService {

	public NetworkService(CameraHttpClient client) {
		super(client);

	}

	public List<WirelessNetwork> scanWirelessNetworks() throws MarshallException, IOException, UnmarshallException {
		ScanWirelessNetworks request = new ScanWirelessNetworks();
		WirelessNetworks nets = client.processRequest(request, WirelessNetworks.class);
		return nets.getNetworks();
	}

	public WirelessNetwork getWirelessSettings() throws MarshallException, IOException, UnmarshallException {
		GetWirelessProperties request = new GetWirelessProperties();
		return client.processRequest(request, WirelessNetwork.class);
	}

	public boolean setWirelessNetwork(WirelessNetwork net) throws MarshallException, IOException, UnmarshallException {
		SetWirelessProperties request = new SetWirelessProperties();
		request.setProperties(net);
		SimpleResponse response = client.processRequest(request, SimpleResponse.class);
		return response.isSuccessfull();
	}

	public boolean isWirelessConfigurationValid(WirelessNetwork network)
			throws MarshallException, IOException, UnmarshallException {
		PrepareWirelessValidation prepare = new PrepareWirelessValidation();
		prepare.setNetwork(network);
		SimpleResponse tmpResp = client.processRequest(prepare, SimpleResponse.class );
		if (tmpResp.isSuccessfull()) {
			GetWirelessValidation request = new GetWirelessValidation();
			WirelessValidationResult response = client.processRequest(request,
					WirelessValidationResult.class);
			return response.isValidated();
		} else {
			return false;
		}
	}

	public NetworkProperties getNetworkProperties() throws MarshallException, IOException, UnmarshallException {
		GetNetworkProperties request = new GetNetworkProperties();
		return client.processRequest(request, NetworkProperties.class);
	}

	public boolean setNetworkProperties(NetworkProperties props)
			throws MarshallException, IOException, UnmarshallException {
		SetNetworkProperties request = new SetNetworkProperties();
		request.setProperties(props);
		SimpleResponse response = client.processRequest(request, SimpleResponse.class );
		return response.isSuccessfull();
	}
}
