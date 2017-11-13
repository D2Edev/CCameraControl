package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.TVFormat;
import io.github.d2edev.ccc.enums.VideoMode;

@Model(Model.COMPLEX)
public class VideoSourceProperties {
	
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
		builder.append("VideoSourceProperties [videoMode=");
		builder.append(resolutionMode);
		builder.append(", format=");
		builder.append(tvFormat);
		builder.append(", profile=");
		builder.append(h264Profile);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h264Profile == null) ? 0 : h264Profile.hashCode());
		result = prime * result + ((resolutionMode == null) ? 0 : resolutionMode.hashCode());
		result = prime * result + ((tvFormat == null) ? 0 : tvFormat.hashCode());
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
		VideoSourceProperties other = (VideoSourceProperties) obj;
		if (h264Profile != other.h264Profile)
			return false;
		if (resolutionMode != other.resolutionMode)
			return false;
		if (tvFormat != other.tvFormat)
			return false;
		return true;
	}
	
	
	

}
