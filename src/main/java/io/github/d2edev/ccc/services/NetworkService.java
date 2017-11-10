package io.github.d2edev.ccc.services;

import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.models.ConnectedUsers;
import io.github.d2edev.ccc.requests.system.GetConnectedUsersNumber;

public class NetworkService extends AbstractService{

	public NetworkService(CameraHttpClient client) {
		super(client);

	}
	
	public int getConnectedUsersNumber() throws Exception{
		GetConnectedUsersNumber request=new GetConnectedUsersNumber();
		ConnectedUsers users=(ConnectedUsers)client.processRequest(request,request.getExpectedResponseType());
		return users.getConnectedUsersQty();
	}

}
