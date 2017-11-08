package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;

public class DeviceType {
	//reply example:
	//var devtype="C6F0SeZ0N0P0L0";
	
	@QueryParameter(get="devtype")
	private String encodedDeviceType;
	
	public String getEncodedDeviceType() {
		return encodedDeviceType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceType [");
		builder.append(encodedDeviceType);
		builder.append("]");
		return builder.toString();
	}
	
	

}
