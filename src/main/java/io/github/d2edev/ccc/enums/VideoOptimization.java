package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum VideoOptimization implements ValueProvider{
	
	
	FRAMERATE(0), ILLUMINANCE(1);

	private VideoOptimization(int id) {
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
