package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;

@Model(Model.COMPLEX)
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
	private String model;

	// hadrware version
	private String hardwareVersion;

	// firmware version
	private String softwareVersion;

	// web component version?
	private String webVersion;

	// onfiv device name
	private String name;

	// camera start date and time
	private String startDateTime;

	// uPNP status
	private String unpStatus;

	// manufacture's DDNS status
	private String manufacturerDDNSStatus;

	// Third Party DDNS status:
	private String thirdPartyDDNSStatus;

	// ?? unknown
	private int platformStatus;

	// ?? status of sd card
	private String sdCardStatus;

	// free space of sd card, kB
	private long sdCardFreeSpace;

	// total space of sd card, kB
	private long sdCardTotalSpace;


	public String getModel() {
		return model;
	}

	@SetModelValue(key = "model")
	public void setModel(String model) {
		this.model = model;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	@SetModelValue(key = "hardVersion")
	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	@SetModelValue(key = "softVersion")
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public String getWebVersion() {
		return webVersion;
	}

	@SetModelValue(key = "webVersion")
	public void setWebVersion(String webVersion) {
		this.webVersion = webVersion;
	}

	public String getName() {
		return name;
	}

	@SetModelValue(key = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	@SetModelValue(key = "startdate")
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getUnpStatus() {
		return unpStatus;
	}

	@SetModelValue(key = "upnpstatus")
	public void setUnpStatus(String unpStatus) {
		this.unpStatus = unpStatus;
	}

	public String getManufacturerDDNSStatus() {
		return manufacturerDDNSStatus;
	}

	@SetModelValue(key = "facddnsstatus")
	public void setManufacturerDDNSStatus(String manufacturerDDNSStatus) {
		this.manufacturerDDNSStatus = manufacturerDDNSStatus;
	}

	public String getThirdPartyDDNSStatus() {
		return thirdPartyDDNSStatus;
	}

	public void setThirdPartyDDNSStatus(String thirdPartyDDNSStatus) {
		this.thirdPartyDDNSStatus = thirdPartyDDNSStatus;
	}

	public int getPlatformStatus() {
		return platformStatus;
	}

	@SetModelValue(key = "platformstatus")
	public void setPlatformStatus(int platformStatus) {
		this.platformStatus = platformStatus;
	}

	public String getSdCardStatus() {
		return sdCardStatus;
	}


	@SetModelValue(key = "sdstatus")
	public void setSdCardStatus(String sdCardStatus) {
		this.sdCardStatus = sdCardStatus;
	}

	public long getSdCardFreeSpace() {
		return sdCardFreeSpace;
	}

	@SetModelValue(key = "sdfreespace")
	public void setSdCardFreeSpace(long sdCardFreeSpace) {
		this.sdCardFreeSpace = sdCardFreeSpace;
	}

	public long getSdCardTotalSpace() {
		return sdCardTotalSpace;
	}

	@SetModelValue(key = "sdtotalspace")
	public void setSdCardTotalSpace(long sdCardTotalSpace) {
		this.sdCardTotalSpace = sdCardTotalSpace;
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
