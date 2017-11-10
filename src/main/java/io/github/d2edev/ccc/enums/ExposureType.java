package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum ExposureType implements ValueProvider{
	
	
	AUTO(0), INDOOR(1), OUTDOOR(2);

	private ExposureType(int id) {
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
