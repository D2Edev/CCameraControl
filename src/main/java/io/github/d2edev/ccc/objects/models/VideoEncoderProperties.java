package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryInputParameterModifier;
import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.ImageQuality;
import io.github.d2edev.ccc.objects.support.RateControl;

@QueryInputParameterModifier("_")
public class VideoEncoderProperties {
	
	@QueryParameter("bps")
	private int bps;
	
	@QueryParameter("fps")
	private int fps;
	
	@QueryParameter("gop")
	private int gop;
	
	@QueryParameter("gop")
	private RateControl rateControl;
	
	@QueryParameter("imagegrade")
	private ImageQuality quality;
		
	@QueryParameter("width")
	private int width;
	
	@QueryParameter("width")
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

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	

}
