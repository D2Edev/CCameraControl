package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum WiFiEncryption implements ValueProvider{
	
	
	NONE(0),
	WEP(1),
	WPA_PSK(2),
	WPA2_PSK(3)	;

	private WiFiEncryption(int id) {
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
