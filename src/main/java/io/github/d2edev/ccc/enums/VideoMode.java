package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum VideoMode implements ValueProvider{
	
	_640x480_320x240(18),
	_640x480_160x120(19),
	_320_240_320x240(21),
	_320x240_160x120(22),
	_160x120_320x240(24),
	_160x120_160x160(25),
	_1280x720_640x352(31),
	_1280x720_320x176(32),
	_640x352_640x352(33),
	_640x352_320x176(34),
	_320x176_640x352(35),
	_320x176_320x176(36);

	private VideoMode(int id) {
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
