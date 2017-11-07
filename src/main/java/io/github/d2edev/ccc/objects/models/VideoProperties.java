package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.H264profile;
import io.github.d2edev.ccc.objects.support.TVFormat;
import io.github.d2edev.ccc.objects.support.VideoMode;


public class VideoProperties {
	
	@QueryParameter("videomode")
	private VideoMode videoMode;

	@QueryParameter("vinorm")
	private TVFormat format;
	
	@QueryParameter("profile")
	private H264profile profile;
	
	public VideoMode getVideoMode() {
		return videoMode;
	}
	public void setVideoMode(VideoMode videoMode) {
		this.videoMode = videoMode;
	}
	public TVFormat getFormat() {
		return format;
	}
	public void setFormat(TVFormat format) {
		this.format = format;
	}
	public H264profile getProfile() {
		return profile;
	}
	public void setProfile(H264profile profile) {
		this.profile = profile;
	}
	
	
	

}
