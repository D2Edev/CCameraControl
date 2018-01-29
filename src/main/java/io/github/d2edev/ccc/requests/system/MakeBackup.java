package io.github.d2edev.ccc.requests.system;

import io.github.d2edev.ccc.api.AbstractCamRequest;

//response is byte array
public class MakeBackup extends AbstractCamRequest{
	

	{
		endpoint=BACKUP_ENDPOINT;
		method=METHOD_GET;
	}

}
