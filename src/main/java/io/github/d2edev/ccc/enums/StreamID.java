package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum StreamID implements ValueProvider {

	Main(11), Sub(12);

	private StreamID(int id) {
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
