package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.WiFiSecurityMode;
import io.github.d2edev.ccc.enums.WifiKeyEncryption;
import io.github.d2edev.ccc.enums.WifiInfrastructureMode;

@Model(Model.COMPLEX)
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
	private WifiKeyEncryption keyEncryption;

	// Connection mode:
	private WifiInfrastructureMode mode;

	// security
	private WiFiSecurityMode security;

	// wifi password
	private String passphrase;

	// switch on or off
	private IntegerState state;

	// SSID
	private String ssid;

	// wifi channel
	private int channel;

	// network strength
	private int strength;

	// comment for setter related to [wf_enc] goes here
	@SetModelValue(key = "wf_enc")
	public void setKeyEncryption(WifiKeyEncryption keyEncryption) {
		this.keyEncryption = keyEncryption;
	}

	// comment for getter related to [wf_enc] goes here
	@GetModelValue(key = "wf_enc")
	public WifiKeyEncryption getKeyEncryption() {
		return keyEncryption;
	}

	// comment for setter related to [wf_mode] goes here
	@SetModelValue(key = "wf_mode")
	public void setInfrastructureMode(WifiInfrastructureMode ifmode) {
		this.mode = ifmode;
	}

	// comment for getter related to [wf_mode] goes here
	@GetModelValue(key = "wf_mode")
	public WifiInfrastructureMode getInfrastructureMode() {
		return mode;
	}

	// comment for setter related to [wf_auth] goes here
	@SetModelValue(key = "wf_auth")
	public void setWiFiSecurityMode(WiFiSecurityMode smode) {
		this.security = smode;
	}

	// comment for getter related to [wf_auth] goes here
	@GetModelValue(key = "wf_auth")
	public WiFiSecurityMode getWiFiSecurityMode() {
		return security;
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
		if (ssid == null || ssid.isEmpty())
			return;
		if (ssid.length() > MAX_SSID_NAME_LENGTH) {
			this.ssid = ssid.substring(0, MAX_SSID_NAME_LENGTH - 1);
		} else {
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
		builder.append("WirelessNetwork [keyEncryption=");
		builder.append(keyEncryption);
		builder.append(", mode=");
		builder.append(mode);
		builder.append(", security=");
		builder.append(security);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyEncryption == null) ? 0 : keyEncryption.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((passphrase == null) ? 0 : passphrase.hashCode());
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + ((ssid == null) ? 0 : ssid.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WirelessNetwork other = (WirelessNetwork) obj;
		if (keyEncryption != other.keyEncryption)
			return false;
		if (mode != other.mode)
			return false;
		if (passphrase == null) {
			if (other.passphrase != null)
				return false;
		} else if (!passphrase.equals(other.passphrase))
			return false;
		if (security != other.security)
			return false;
		if (ssid == null) {
			if (other.ssid != null)
				return false;
		} else if (!ssid.equals(other.ssid))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	
	
}
