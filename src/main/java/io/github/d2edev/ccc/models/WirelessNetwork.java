package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.WiFiEncryption;
import io.github.d2edev.ccc.enums.WiFiKeyEncoding;
import io.github.d2edev.ccc.enums.WiFiMode;

@ModelType(ModelType.COMPLEX)
public class WirelessNetwork {

	public static final int MAX_SSID_NAME_LENGTH = 32;

	// ***Generated automatically ***

	// response example:
	// var wf_enable="1";
	// var wf_ssid="MySuperDuperAP";
	// var wf_auth="3";
	// var wf_key="mysecretkey";
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
	private IntegerState state;

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
	public void setState(IntegerState state) {
		this.state = state;
	}

	// comment for getter related to [wf_enable] goes here
	@GetModelValue(key = "wf_enable")
	public IntegerState getState() {
		return state;
	}

	// cam supports max 32 characters
	@SetModelValue(key = "wf_ssid")
	public void setSSID(String ssid) {
		if(ssid==null||ssid.isEmpty())return;
		if(ssid.length()>MAX_SSID_NAME_LENGTH){
			this.ssid=ssid.substring(0, MAX_SSID_NAME_LENGTH-1);
		}else{
			this.ssid = ssid;			
		}
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
		builder.append("WirelessNetwork [encoding=");
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
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", strength=");
		builder.append(strength);
		builder.append("]");
		return builder.toString();
	}



	
	
}
