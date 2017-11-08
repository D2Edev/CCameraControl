package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum Status implements ValueProvider{
	
	ON("on"), OFF("off"), FAILED("failed"), OUT("out");

	private Status(String id) {
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