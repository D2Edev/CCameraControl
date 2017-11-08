package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameterSplitter;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.ImageQuality;
import io.github.d2edev.ccc.objects.support.RateControl;

@QueryParameterSplitter("_")
public class VideoEncoderProperties {
	
	//reply example:
//	var bps_2="500";
//	var fps_2="10";
//	var gop_2="20";
//	var brmode_2="0";
//	var imagegrade_2="3";
//	var width_2="640";
//	var height_2="352";
	
	@QueryParameter(get = "bps")
	private int bps;
	
	@QueryParameter(get = "fps")
	private int fps;
	
	@QueryParameter(get = "gop")
	private int gop;
	
	@QueryParameter(get = "brmode")
	private RateControl rateControl;
	
	@QueryParameter(get = "imagegrade")
	private ImageQuality quality;
		
	@QueryParameter(get="width",out=false)
	private int width;
	
	@QueryParameter(get="height",out=false)
	private int height;

	public int getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getGop() {
		return gop;
	}

	public void setGop(int gop) {
		this.gop = gop;
	}

	public RateControl getRateControl() {
		return rateControl;
	}

	public void setRateControl(RateControl rateControl) {
		this.rateControl = rateControl;
	}

	public ImageQuality getQuality() {
		return quality;
	}

	public void setQuality(ImageQuality quality) {
		this.quality = quality;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VideoEncoderProperties [bps=");
		builder.append(bps);
		builder.append(", fps=");
		builder.append(fps);
		builder.append(", gop=");
		builder.append(gop);
		builder.append(", rateControl=");
		builder.append(rateControl);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

	
}
