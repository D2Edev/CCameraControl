package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.State;
import io.github.d2edev.ccc.enums.WiFiEncryption;
import io.github.d2edev.ccc.enums.WiFiKeyEncoding;
import io.github.d2edev.ccc.enums.WiFiMode;

@ModelType(ModelType.COMPLEX)
public class WirelessProperties {

	// ***Generated automatically ***

	// response example:
	// var wf_enable="1";
	// var wf_ssid="PiAP";
	// var wf_auth="3";
	// var wf_key="4321oleg";
	// var wf_enc="1";
	// var wf_mode="0";

	// Key type
	private WiFiKeyEncoding encoding;

	// Connection mode:
	private WiFiMode mode;

	// encryption
	private WiFiEncryption encryption;

	// wifi password
	private String passphrase;

	// switch on or off
	private State state;

	// SSID
	private String ssid;
	
	//wifi channel 
	private int channel;
	
	//network strength
	private int strength;

	// comment for setter related to [wf_enc] goes here
	@SetModelValue(key = "wf_enc")
	public void setKeyEncoding(WiFiKeyEncoding encoding) {
		this.encoding = encoding;
	}

	// comment for getter related to [wf_enc] goes here
	@GetModelValue(key = "wf_enc")
	public WiFiKeyEncoding getKeyEncoding() {
		return encoding;
	}

	// comment for setter related to [wf_mode] goes here
	@SetModelValue(key = "wf_mode")
	public void setWiFiMode(WiFiMode wf_mode) {
		this.mode = wf_mode;
	}

	// comment for getter related to [wf_mode] goes here
	@GetModelValue(key = "wf_mode")
	public WiFiMode getWiFiMode() {
		return mode;
	}

	// comment for setter related to [wf_auth] goes here
	@SetModelValue(key = "wf_auth")
	public void setWiFiEncryption(WiFiEncryption encryption) {
		this.encryption = encryption;
	}

	// comment for getter related to [wf_auth] goes here
	@GetModelValue(key = "wf_auth")
	public WiFiEncryption getWiFiEncryption() {
		return encryption;
	}

	// comment for setter related to [wf_key] goes here
	@SetModelValue(key = "wf_key")
	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	// comment for getter related to [wf_key] goes here
	@GetModelValue(key = "wf_key")
	public String getPassphrase() {
		return passphrase;
	}

	// comment for setter related to [wf_enable] goes here
	@SetModelValue(key = "wf_enable")
	public void setState(State state) {
		this.state = state;
	}

	// comment for getter related to [wf_enable] goes here
	@GetModelValue(key = "wf_enable")
	public State getState() {
		return state;
	}

	// comment for setter related to [wf_ssid] goes here
	@SetModelValue(key = "wf_ssid")
	public void setSSID(String ssid) {
		this.ssid = ssid;
	}

	// comment for getter related to [wf_ssid] goes here
	@GetModelValue(key = "wf_ssid")
	public String getSSID() {
		return ssid;
	}
	
	

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WirelessProperties [encoding=");
		builder.append(encoding);
		builder.append(", mode=");
		builder.append(mode);
		builder.append(", encryption=");
		builder.append(encryption);
		builder.append(", passphrase=");
		builder.append(passphrase);
		builder.append(", state=");
		builder.append(state);
		builder.append(", ssid=");
		builder.append(ssid);
		builder.append("]");
		return builder.toString();
	}

	
	
}
