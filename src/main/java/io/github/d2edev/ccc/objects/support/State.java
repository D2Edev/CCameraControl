package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum State implements ValueProvider{
	
	
	OFF(0), ON(1);

	private State(int id) {
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
