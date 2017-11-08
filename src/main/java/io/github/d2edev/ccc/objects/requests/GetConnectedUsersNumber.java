package io.github.d2edev.ccc.objects.requests;

import io.github.d2edev.ccc.objects.base.CameraRequest;
import io.github.d2edev.ccc.objects.base.QueryCommand;
import io.github.d2edev.ccc.objects.models.ConnectedUsers;

@QueryCommand("getstreamnum")
public class GetConnectedUsersNumber implements CameraRequest{

	@Override
	public Class<?> getExpectedResponseType() {
		return ConnectedUsers.class;
	}

}
