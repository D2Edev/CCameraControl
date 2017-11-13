package io.github.d2edev.ccc.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.DNSMode;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.helper.Key;

@Model
public class NetworkProperties {

	public static final String MASK_PATTERN = "^(((255\\.){3}(255|254|252|248|240|224|192|128|0+))|"
			+ "((255\\.){2}(255|254|252|248|240|224|192|128|0+)\\.0)|"
			+ "((255\\.)(255|254|252|248|240|224|192|128|0+)(\\.0+){2})|"
			+ "((255|254|252|248|240|224|192|128|0+)(\\.0+){3}))$";

	public static final String IP_PATTERN = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	public static final String MAC_PATTERN = "([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})";

	private Pattern maskPattern = Pattern.compile(MASK_PATTERN);
	private Pattern ipPattern = Pattern.compile(IP_PATTERN);
	private Pattern macPattern = Pattern.compile(MAC_PATTERN);

	// ***Generated automatically ***

	// reply example: var dnsstat="0";
	@Key("dnsstat")
	private DNSMode dnsmode;

	// reply example: var netmask="255.255.255.0";
	@Key("netmask")
	private String netmask;

	// reply example: var ip="192.168.0.201";
	@Key("ip")
	private String ip;

	// reply example: var fdnsip="8.8.8.8";
	@Key("fdnsip")
	private String firstDnsIP;

	// reply example: var dhcpflag="on";
	@Key("dhcpflag")
	private StringState useDHCP;

	// reply example: var macaddress="00:E0:F8:A2:8E:E4";
	@Key("macaddress")
	private String macAddress;

	// reply example: var networktype="LAN";
	@Key("networktype")
	private String networktype;

	// reply example: var gateway="192.168.0.1";
	@Key("gateway")
	private String gateway;

	// reply example: var sdnsip="";
	@Key("sdnsip")
	private String secondDnsIP;

	
	
	@SetModelValue(key = "dnsstat")
	public void setDnsmode(DNSMode dnsmode) {
		this.dnsmode = dnsmode;
	}

	@GetModelValue(key = "dnsstat")
	public DNSMode getDnsmode() {
		return dnsmode;
	}

	@SetModelValue(key = "netmask")
	public void setNetmask(String netmask) {
		Matcher m=maskPattern.matcher(netmask);
		if(m.matches()){
			this.netmask = netmask;			
		}else{
			throw new IllegalArgumentException("Not valid netmask: " + netmask);			
		}
	}

	@GetModelValue(key = "netmask")
	public String getNetmask() {
		return netmask;
	}

	// get and set keys are DIFFERENT
	//accepts null or valid ip
	@SetModelValue(key = "ip")
	public void setIp(String ip) {
		if(ip==null){
			this.ip=null;
			return;
		}
		Matcher m=ipPattern.matcher(ip);
		if(m.matches()){
			this.ip = ip;			
		}else{
			throw new IllegalArgumentException("Not valid ip address: " + ip);	
		}
	}

	//  get and set keys are DIFFERENT
	@GetModelValue(key = "ipaddr")
	public String getIp() {
		return ip;
	}

	//accepts null or valid ip
	@SetModelValue(key = "fdnsip")
	public void setFirstDnsIP(String firstDnsIP) {
		if(ip==null){
			this.firstDnsIP = firstDnsIP;
			return;
		}
		Matcher m=ipPattern.matcher(firstDnsIP);
		if(m.matches()){
			this.firstDnsIP = firstDnsIP;
		}else{
			throw new IllegalArgumentException("DNS one. Not valid ip address: " + firstDnsIP);	
		}
	}

	@GetModelValue(key = "fdnsip")
	public String getFirstDnsIP() {
		return firstDnsIP;
	}

	@SetModelValue(key = "dhcpflag")
	public void setUseDHCP(StringState state) {
		this.useDHCP = state;
	}

	@GetModelValue(key = "dhcpflag")
	public StringState getUseDHCP() {
		return useDHCP;
	}

	// accepts only valid mac addresses
	@SetModelValue(key = "macaddress")
	public void setMacAddress(String macAddress) {
		Matcher m=macPattern.matcher(macAddress);
		if(m.matches()){
			this.macAddress = macAddress;			
		}else{
			throw new IllegalArgumentException("Not valid MAC address: " + firstDnsIP);				
		}
	}

	public String getMacAddress() {
		return macAddress;
	}

	@SetModelValue(key = "networktype")
	public void setNetworktype(String networktype) {
		this.networktype = networktype;
	}

	// not used in set
	public String getNetworktype() {
		return networktype;
	}

	//accepts null or valid ip
	@SetModelValue(key = "gateway")
	public void setGateway(String gateway) {
		if(ip==null){
			this.gateway=gateway;
			return;
		}
		Matcher m=ipPattern.matcher(firstDnsIP);
		if(m.matches()){
			this.gateway=gateway;
		}else{
			throw new IllegalArgumentException("Gateway. Not valid ip address: " + firstDnsIP);	
		}
	}

	// comment for getter related to [gateway] goes here
	@GetModelValue(key = "gateway")
	public String getGateway() {
		return gateway;
	}

	// comment for setter related to [sdnsip] goes here
	@SetModelValue(key = "sdnsip")
	public void setSecondDnsIP(String secondDnsIP) {
		if(ip==null){
			this.secondDnsIP = secondDnsIP;
			return;
		}
		Matcher m=ipPattern.matcher(firstDnsIP);
		if(m.matches()){
			this.secondDnsIP = secondDnsIP;
		}else{
			throw new IllegalArgumentException("DNS two. Not valid ip address: " + firstDnsIP);	
		}
	}

	// comment for getter related to [sdnsip] goes here
	@GetModelValue(key = "sdnsip")
	public String getSecondDnsIP() {
		return secondDnsIP;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NetworkProperties [dnsmode=");
		builder.append(dnsmode);
		builder.append(", netmask=");
		builder.append(netmask);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", firstDnsIP=");
		builder.append(firstDnsIP);
		builder.append(", useDHCP=");
		builder.append(useDHCP);
		builder.append(", macAddress=");
		builder.append(macAddress);
		builder.append(", networktype=");
		builder.append(networktype);
		builder.append(", gateway=");
		builder.append(gateway);
		builder.append(", secondDnsIP=");
		builder.append(secondDnsIP);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dnsmode == null) ? 0 : dnsmode.hashCode());
		result = prime * result + ((firstDnsIP == null) ? 0 : firstDnsIP.hashCode());
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((macAddress == null) ? 0 : macAddress.hashCode());
		result = prime * result + ((netmask == null) ? 0 : netmask.hashCode());
		result = prime * result + ((networktype == null) ? 0 : networktype.hashCode());
		result = prime * result + ((secondDnsIP == null) ? 0 : secondDnsIP.hashCode());
		result = prime * result + ((useDHCP == null) ? 0 : useDHCP.hashCode());
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
		NetworkProperties other = (NetworkProperties) obj;
		if (dnsmode != other.dnsmode)
			return false;
		if (firstDnsIP == null) {
			if (other.firstDnsIP != null)
				return false;
		} else if (!firstDnsIP.equals(other.firstDnsIP))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (netmask == null) {
			if (other.netmask != null)
				return false;
		} else if (!netmask.equals(other.netmask))
			return false;
		if (networktype == null) {
			if (other.networktype != null)
				return false;
		} else if (!networktype.equals(other.networktype))
			return false;
		if (secondDnsIP == null) {
			if (other.secondDnsIP != null)
				return false;
		} else if (!secondDnsIP.equals(other.secondDnsIP))
			return false;
		if (useDHCP != other.useDHCP)
			return false;
		return true;
	}

	
	
}
