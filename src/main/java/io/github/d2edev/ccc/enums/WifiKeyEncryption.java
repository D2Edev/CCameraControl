package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum WifiKeyEncryption implements ValueProvider{
	
	
	TKIP(0), AES(1), NONE(2);

	private WifiKeyEncryption(int id) {
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
