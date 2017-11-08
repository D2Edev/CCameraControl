package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum ImageQuality implements ValueProvider{
	
	BEST(1), BETTER(2), GOOD(3), NORMAL(4), POOR(5), WORST(6);

	private ImageQuality(int id) {
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
