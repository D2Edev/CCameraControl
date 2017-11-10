package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum StringState implements ValueProvider{
	
	ENABLED("on"), DISABLED("off");

	private StringState(String id) {
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