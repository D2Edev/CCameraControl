package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum TVFormat implements ValueProvider{
	
	PAL("P"), NTSC("N");

	private TVFormat(String id) {
		this.id = id;
	}

	private String id;

	public Object value() {
		return id;
	}

}
