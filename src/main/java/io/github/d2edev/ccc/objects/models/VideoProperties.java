package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.ModelType;
import io.github.d2edev.ccc.objects.base.SetModelValue;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.VideoMode;

@ModelType(ModelType.COMPLEX)
public class VideoProperties {
	
	private VideoMode resolutionMode;
	private TVFormat tvFormat;
	private H264profile h264Profile;
	
	@GetModelValue(key = "videomode")
	public VideoMode getVideoMode() {
		return resolutionMode;
	}
	
	@SetModelValue(key = "videomode")
	public void setVideoMode(VideoMode videoMode) {
		this.resolutionMode = videoMode;
	}

	@GetModelValue(key = "vinorm")
	public TVFormat getFormat() {
		return tvFormat;
	}
	
	@SetModelValue(key = "vinorm")
	public void setFormat(TVFormat format) {
		this.tvFormat = format;
	}
	
	@GetModelValue(key = "profile")
	public H264profile getProfile() {
		return h264Profile;
	}

	@SetModelValue(key = "profile")
	public void setProfile(H264profile profile) {
		this.h264Profile = profile;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VideoProperties [videoMode=");
		builder.append(resolutionMode);
		builder.append(", format=");
		builder.append(tvFormat);
		builder.append(", profile=");
		builder.append(h264Profile);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
