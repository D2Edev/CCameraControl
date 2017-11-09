package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum WiFiKeyEncoding implements ValueProvider{
	
	
	TKIP(0), AES(1);

	private WiFiKeyEncoding(int id) {
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
