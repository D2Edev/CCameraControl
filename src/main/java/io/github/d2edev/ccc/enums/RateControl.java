package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum RateControl implements ValueProvider{

	FIXED(0), VARIABLE(1);

	private RateControl(int id) {
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
