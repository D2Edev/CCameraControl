package io.github.d2edev.ccc.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.IVideoResolution;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.TVFormat;

/**
 * @author ddmitry
 *
 */
@Model(Model.COMPLEX)
public class VideoSourceProperties {
	
	private static final Map<Integer,Pair<IVideoResolution>> resolutionMap=new HashMap<>();
	public static final IVideoResolution w160h120=new Resolution(160, 120);
	public static final IVideoResolution w320h240=new Resolution(320, 240);
	public static final IVideoResolution w320h176=new Resolution(320, 176);
	public static final IVideoResolution w640h352=new Resolution(640, 352);
	public static final IVideoResolution w640h480=new Resolution(640, 480);
	public static final IVideoResolution w1280h720=new Resolution(1280, 720);
	
	{
		
		
//		_640x480_320x240(18),
		resolutionMap.put(18,Pair.from(w640h480,w320h240));
//		_640x480_160x120(19),
		resolutionMap.put(19,Pair.from(w640h480,w160h120));
//		_320_240_320x240(21),
		resolutionMap.put(21,Pair.from(w320h240,w320h240));
//		_320x240_160x120(22),
		resolutionMap.put(22,Pair.from(w320h240,w160h120));
//		_160x120_320x240(24),
		resolutionMap.put(24,Pair.from(w160h120,w320h240));
//		_160x120_160x160(25),
		resolutionMap.put(25,Pair.from(w160h120,w160h120));
//		_1280x720_640x352(31),
		resolutionMap.put(31,Pair.from(w1280h720,w640h352));
//		_1280x720_320x176(32),
		resolutionMap.put(32,Pair.from(w1280h720,w320h176));
//		_640x352_640x352(33),
		resolutionMap.put(33,Pair.from(w640h352,w640h352));
//		_640x352_320x176(34),
		resolutionMap.put(34,Pair.from(w640h352,w320h176));
//		_320x176_640x352(35),
		resolutionMap.put(35,Pair.from(w320h176,w640h352));
//		_320x176_320x176(36);
		resolutionMap.put(36,Pair.from(w320h176,w320h176));
	}
	
	private TVFormat tvFormat;
	private H264profile h264Profile;
	private int mode;

	@GetModelValue(key = "videomode")
	public int getMode() {
		return mode;
	}
	
	@SetModelValue(key = "videomode")
	public void setMode(int mode) {
		this.mode=mode;
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
	
	public List<IVideoResolution> getResolutions(){
		Pair<IVideoResolution> pair=resolutionMap.get(mode);
		return pair==null? null:Pair.asList(pair);
	}
	
	public void setResolutions(List<IVideoResolution> resolutions){
		Pair<IVideoResolution> pair=Pair.fromList(resolutions);
		for (Entry<Integer, Pair<IVideoResolution>> resEntry : resolutionMap.entrySet()) {
			if(resEntry.getValue().equals(pair)){
				mode=resEntry.getKey();
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h264Profile == null) ? 0 : h264Profile.hashCode());
		result = prime * result + mode;
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
		if (mode != other.mode)
			return false;
		if (tvFormat != other.tvFormat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VideoSourceProperties ");
		builder.append("{").append(mode).append("}");
		builder.append("[tvFormat=");
		builder.append(tvFormat);
		builder.append(", h264Profile=");
		builder.append(h264Profile);
		builder.append(", resolutions=");
		builder.append(resolutionMap.get(mode));
		builder.append("]");
		return builder.toString();
	}

	public static VideoSourceProperties copy(VideoSourceProperties sourceProps) {
		if(sourceProps==null)return null;
		VideoSourceProperties copy=new VideoSourceProperties();
		copy.setFormat(sourceProps.getFormat());
		copy.setMode(sourceProps.getMode());
		copy.setProfile(sourceProps.getProfile());
		return copy;
	}
	
	

}
