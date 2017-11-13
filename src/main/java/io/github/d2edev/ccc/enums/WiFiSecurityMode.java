package io.github.d2edev.ccc.enums;

import io.github.d2edev.ccc.api.ValueProvider;

public enum WiFiSecurityMode implements ValueProvider{
	
	
	OPEN(0),
	WEP(1),
	WPA_PSK(2),
	WPA2_PSK(3)	;

	private WiFiSecurityMode(int id) {
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
	
	public static WiFiSecurityMode parseString(String input) {
		switch (input) {
		case "WPA2-PSK":{
			return WiFiSecurityMode.WPA2_PSK;
		}
		case "WPA-PSK":{
			return WiFiSecurityMode.WPA_PSK;
		}
		case "WEP":{
			return WiFiSecurityMode.WEP;
		}
		case "OPEN":{
			return WiFiSecurityMode.OPEN;
		}
		default:
			return null;
		}
	}

}
