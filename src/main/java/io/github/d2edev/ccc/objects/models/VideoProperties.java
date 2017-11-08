package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.VideoMode;


public class VideoProperties {
	
	@QueryParameter(get = "videomode")
	private VideoMode resolutionMode;

	@QueryParameter(get = "vinorm")
	private TVFormat tvFormat;
	
	@QueryParameter(get = "profile")
	private H264profile h264Profile;
	
	public VideoMode getVideoMode() {
		return resolutionMode;
	}
	public void setVideoMode(VideoMode videoMode) {
		this.resolutionMode = videoMode;
	}
	public TVFormat getFormat() {
		return tvFormat;
	}
	public void setFormat(TVFormat format) {
		this.tvFormat = format;
	}
	public H264profile getProfile() {
		return h264Profile;
	}
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
