package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum WiFiMode implements ValueProvider{
	
	
	ROUTE(0), PEER2PEER(1);

	private WiFiMode(int id) {
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
