package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.ModelType;
import io.github.d2edev.ccc.objects.base.SetModelValue;
import io.github.d2edev.ccc.objects.base.QueryParameterSplitter;
import io.github.d2edev.ccc.objects.support.ImageQuality;
import io.github.d2edev.ccc.objects.support.RateControl;

@ModelType(ModelType.COMPLEX)
@QueryParameterSplitter("_")
public class VideoEncoderProperties {

	// reply example:
	// var bps_2="500";
	// var fps_2="10";
	// var gop_2="20";
	// var brmode_2="0";
	// var imagegrade_2="3";
	// var width_2="640";
	// var height_2="352";

	private int bps;
	private int fps;
	private int gop;
	private RateControl rateControl;
	private ImageQuality quality;
	private int width;
	private int height;

	
	@GetModelValue(key = "bps")
	public int getBps() {
		return bps;
	}

	@SetModelValue(key = "bps")
	public void setBps(int bps) {
		this.bps = bps;
	}

	@GetModelValue(key = "fps")
	public int getFps() {
		return fps;
	}

	@SetModelValue(key = "fps")
	public void setFps(int fps) {
		this.fps = fps;
	}

	@GetModelValue(key = "gop")
	public int getGop() {
		return gop;
	}

	@SetModelValue(key = "gop")
	public void setGop(int gop) {
		this.gop = gop;
	}

	@GetModelValue(key = "brmode")
	public RateControl getRateControl() {
		return rateControl;
	}

	@SetModelValue(key = "brmode")
	public void setRateControl(RateControl rateControl) {
		this.rateControl = rateControl;
	}

	@GetModelValue(key = "imagegrade")
	public ImageQuality getQuality() {
		return quality;
	}

	@SetModelValue(key = "imagegrade")
	public void setQuality(ImageQuality quality) {
		this.quality = quality;
	}

	//not used in set query
	public int getWidth() {
		return width;
	}

	@SetModelValue(key = "width")
	public void setWidth(int width) {
		this.width = width;
	}
	
	//not used in set query
	public int getHeight() {
		return height;
	}
	
	@SetModelValue(key = "height")
	public void setHeight(int height) {
		this.height = height;
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
