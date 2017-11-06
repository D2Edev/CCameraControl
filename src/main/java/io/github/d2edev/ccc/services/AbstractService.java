package io.github.d2edev.ccc.services;

import io.github.d2edev.ccc.util.CameraHttpClient;

public abstract class AbstractService {
	
	protected CameraHttpClient client;

	public AbstractService(CameraHttpClient client) {
		this.client = client;
	}
	
	

}
