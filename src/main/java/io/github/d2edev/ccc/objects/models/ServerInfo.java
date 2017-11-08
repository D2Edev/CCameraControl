package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.Status;

public class ServerInfo {

	// Reply example:
	// var model="C6F0SeZ0N0P0L0";
	// var hardVersion="V1.0.0.1";
	// var softVersion="V11.6.5.1.1-20161213";
	// var webVersion="E-21.0.720.21";
	// var name="Kharkov3";
	// var startdate="2017-11-06 06:45:18";
	// var upnpstatus="failed";
	// var facddnsstatus="failed";
	// var th3ddnsstatus="off";
	// var platformstatus="0";
	// var sdstatus="out";
	// var sdfreespace="0";
	// var sdtotalspace="0";

	// model name
	@QueryParameter(get = "model")
	private String model;

	// hadrware version
	@QueryParameter(get = "hardVersion")
	private String hardwareVersion;

	// firmware version
	@QueryParameter(get = "softVersion")
	private String softwareVersion;

	// web component version?
	@QueryParameter(get = "webVersion")
	private String webVersion;

	// onfiv device name
	@QueryParameter(get = "name")
	private String name;

	// camera start date and time
	@QueryParameter(get = "startdate")
	private String startDateTime;

	// uPNP status
	@QueryParameter(get = "upnpstatus")
	private Status unpStatus;

	// manufacture's DDNS status
	@QueryParameter(get = "facddnsstatus")
	private Status manufacturerDDNSStatus;

	// Third Party DDNS status:
	@QueryParameter(get = "th3ddnsstatus")
	private Status thirdPartyDDNSStatus;

	// ?? unknown
	@QueryParameter(get = "platformstatus")
	private int platformStatus;

	// ?? status of sd card
	@QueryParameter(get = "sdstatus")
	private Status sdCardStatus;

	// free space of sd card
	@QueryParameter(get = "sdfreespace")
	private long sdCardFreeSpace;

	// total space of sd card
	@QueryParameter(get = "sdfreespace")
	private long sdCardTotalSpace;

	public String getModel() {
		return model;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public String getWebVersion() {
		return webVersion;
	}

	public String getName() {
		return name;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public Status getUnpStatus() {
		return unpStatus;
	}

	public Status getManufacturerDDNSStatus() {
		return manufacturerDDNSStatus;
	}

	public Status getThirdPartyDDNSStatus() {
		return thirdPartyDDNSStatus;
	}

	public int getPlatformStatus() {
		return platformStatus;
	}

	public Status getSdCardStatus() {
		return sdCardStatus;
	}

	public long getSdCardFreeSpace() {
		return sdCardFreeSpace;
	}

	public long getSdCardTotalSpace() {
		return sdCardTotalSpace;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerInfo [model=");
		builder.append(model);
		builder.append(", hardwareVersion=");
		builder.append(hardwareVersion);
		builder.append(", softwareVersion=");
		builder.append(softwareVersion);
		builder.append(", webVersion=");
		builder.append(webVersion);
		builder.append(", name=");
		builder.append(name);
		builder.append(", startDateTime=");
		builder.append(startDateTime);
		builder.append(", unpStatus=");
		builder.append(unpStatus);
		builder.append(", manufacturerDDNSStatus=");
		builder.append(manufacturerDDNSStatus);
		builder.append(", thirdPartyDDNSStatus=");
		builder.append(thirdPartyDDNSStatus);
		builder.append(", platformStatus=");
		builder.append(platformStatus);
		builder.append(", sdCardStatus=");
		builder.append(sdCardStatus);
		builder.append(", sdCardFreeSpace=");
		builder.append(sdCardFreeSpace);
		builder.append(", sdCardTotalSpace=");
		builder.append(sdCardTotalSpace);
		builder.append("]");
		return builder.toString();
	}
	
	

}
