package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.ModelType;
import io.github.d2edev.ccc.objects.base.SetModelValue;

@ModelType(ModelType.COMPLEX)
public class DeviceType {
	//reply example:
	//var devtype="C6F0SeZ0N0P0L0";
	
	private String encodedDeviceType;
	
	@GetModelValue(key="devtype")
	public String getEncodedDeviceType() {
		return encodedDeviceType;
	}
	
	@SetModelValue(key="devtype")
	public void setEncodedDeviceType(String encodedDeviceType) {
		this.encodedDeviceType = encodedDeviceType;
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
