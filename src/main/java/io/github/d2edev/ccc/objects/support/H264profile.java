package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum H264profile implements ValueProvider {

	BASELINE(0), MAIN(1);
	
	private H264profile(int id) {
		this.id = id;
	}

	private int id;

	public Object value() {
		return id;
	}

}
