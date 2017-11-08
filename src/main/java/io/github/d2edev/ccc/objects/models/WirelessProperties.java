package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;

public class WirelessProperties {
	//response example:
	//var wf_enable="1";
	//var wf_ssid="PiAP";
	//var wf_auth="3";
	//var wf_key="4321oleg";
	//var wf_enc="1";
	//var wf_mode="0";

	//comment for wf_enc goes here
	@QueryParameter(get="wf_enc")
	private String wf_enc;

	//comment for wf_mode goes here
	@QueryParameter(get="wf_mode")
	private String wf_mode;

	//comment for wf_auth goes here
	@QueryParameter(get="wf_auth")
	private String wf_auth;

	//comment for wf_key goes here
	@QueryParameter(get="wf_key")
	private String wf_key;

	//comment for wf_enable goes here
	@QueryParameter(get="wf_enable")
	private String wf_enable;

	//comment for wf_ssid goes here
	@QueryParameter(get="wf_ssid")
	private String wf_ssid;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WirelessProperties [wf_enc=");
		builder.append(wf_enc);
		builder.append(", wf_mode=");
		builder.append(wf_mode);
		builder.append(", wf_auth=");
		builder.append(wf_auth);
		builder.append(", wf_key=");
		builder.append(wf_key);
		builder.append(", wf_enable=");
		builder.append(wf_enable);
		builder.append(", wf_ssid=");
		builder.append(wf_ssid);
		builder.append("]");
		return builder.toString();
	}
	
	
}
