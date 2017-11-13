package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum WifiInfrastructureMode implements ValueProvider{
	
	
	ROUTE(0), PEER2PEER(1);

	private WifiInfrastructureMode(int id) {
		this.id = id;
	}

	private int id;

	public Object value() {
		return id;
	}
	
	@Override
	public String stringValue() {
		return ""+id;
	}

}
