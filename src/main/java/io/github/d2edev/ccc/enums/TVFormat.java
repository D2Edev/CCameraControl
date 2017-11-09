package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum TVFormat implements ValueProvider{
	
	PAL("P"), NTSC("N");

	private TVFormat(String id) {
		this.id = id;
	}

	private String id;

	public Object value() {
		return id;
	}
	
	@Override
	public String stringValue() {
		return id;
	}

}
