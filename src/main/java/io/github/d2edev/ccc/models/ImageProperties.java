package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.ExposureType;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.enums.VideoOptimization;
import io.github.d2edev.ccc.helper.Key;

/**
 * @author ddmitry
 *
 */
@Model(Model.COMPLEX)
public class ImageProperties {

	// ***Generated automatically ***

	// received response:
	// var display_mode="1";
	// var brightness="50";
	// var saturation="140";
	// var sharpness="60";
	// var contrast="50";
	// var hue="50";
	// var wdr="on";
	// var night="off";
	// var shutter="65535";
	// var flash_shutter="14";
	// var flip="on";
	// var mirrorMode="on";
	// var gc="31744";
	// var ae="2";
	// var targety="48";
	// var noise="0";
	// var gamma="1";
	// var aemode="0";
	// var imgmode="0";

	// enables/disables mirror mode
	@Key("mirror")
	private StringState mirrorMode;

	// picture color mode
	@Key("display_mode")
	private IntegerState colorMode;;

	// enables/disables wide dynamic range mode
	@Key("wdr")
	private StringState wideDynamicRange;

	// unknown parameter - use with caution
	@Key("ae")
	private int valueAE;

	// unknown parameter - use with caution
	@Key("shutter")
	private int shutter;

	// unknown parameter - use with caution
	@Key("night")
	private StringState nightMode;

	// Exposure gain (0-255)
	@Key("targety")
	private int exposure;

	// unknown parameter - use with caution
	@Key("flash_shutter")
	private int flashShutter;

	// try to keep either frame rate or bright picture
	// mostly important for dark scenes
	@Key("imgmode")
	private VideoOptimization optimization;

	// automatic exposure type
	@Key("aemode")
	private ExposureType exposureType;

	// saturation (0-255)
	@Key("saturation")
	private int saturation;

	// brightness (0-100)
	@Key("brightness")
	private int brightness;

	// contrast (0-100)
	@Key("contrast")
	private int contrast;

	// unknown parameter - use with caution
	@Key("noise")
	private int noise;

	// hue (0-255)
	@Key("hue")
	private int hue;

	// sharpness (0-100)
	@Key("sharpness")
	private int sharpness;

	// unknown parameter - use with caution
	// gain control?
	@Key("gc")
	private int gc;

	// flip image?
	@Key("flip")
	private StringState flipMode;

	// gamma, use with caution
	@Key("gamma")
	private int gamma;

	// comment for setter related to [mirrorMode] goes here
	@SetModelValue(key = "mirror")
	public void setMirrorMode(StringState mirrorMode) {
		this.mirrorMode = mirrorMode;
	}

	// comment for getter related to [mirrorMode] goes here
	@GetModelValue(key = "mirror")
	public StringState getMirrorMode() {
		return mirrorMode;
	}

	// comment for setter related to [display_mode] goes here
	@SetModelValue(key = "display_mode")
	public void setColorMode(IntegerState colorMode) {
		this.colorMode = colorMode;
	}

	// comment for getter related to [display_mode] goes here
	// @GetModelValue(key="display_mode") - not used in set request
	public IntegerState getColorMode() {
		return colorMode;
	}

	// comment for setter related to [wdr] goes here
	@SetModelValue(key = "wdr")
	public void setWideDynamicRange(StringState wideDynamicRange) {
		this.wideDynamicRange = wideDynamicRange;
	}

	// comment for getter related to [wdr] goes here
	@GetModelValue(key = "wdr")
	public StringState getWideDynamicRange() {
		return wideDynamicRange;
	}

	// comment for setter related to [ae] goes here
	@SetModelValue(key = "ae")
	public void setValueAE(int valueAE) {
		this.valueAE = valueAE;
	}

	// comment for getter related to [ae] goes here
	@GetModelValue(key = "ae")
	public int getValueAE() {
		return valueAE;
	}

	// comment for setter related to [shutter] goes here
	@SetModelValue(key = "shutter")
	public void setShutter(int shutter) {
		this.shutter = shutter;
	}

	// comment for getter related to [shutter] goes here
	// @GetModelValue(key="shutter") - not used in set request
	public int getShutter() {
		return shutter;
	}

	// comment for setter related to [night] goes here
	@SetModelValue(key = "night")
	public void setNightMode(StringState nightMode) {
		this.nightMode = nightMode;
	}

	// comment for getter related to [night] goes here
	@GetModelValue(key = "night")
	public StringState getNightMode() {
		return nightMode;
	}

	// comment for setter related to [targety] goes here
	@SetModelValue(key = "targety")
	public void setExposure(int exposure) {
		this.exposure = exposure;
	}

	// comment for getter related to [targety] goes here
	@GetModelValue(key = "targety")
	public int getExposure() {
		return exposure;
	}

	// comment for setter related to [flash_shutter] goes here
	@SetModelValue(key = "flash_shutter")
	public void setFlashShutter(int flashShutter) {
		this.flashShutter = flashShutter;
	}

	// comment for getter related to [flash_shutter] goes here
	// @GetModelValue(key = "flash_shutter") - not used in set request
	public int getFlashShutter() {
		return flashShutter;
	}

	// comment for setter related to [imgmode] goes here
	@SetModelValue(key = "imgmode")
	public void setOptimization(VideoOptimization optimization) {
		this.optimization = optimization;
	}

	// comment for getter related to [imgmode] goes here
	@GetModelValue(key = "imgmode")
	public VideoOptimization getOptimization() {
		return optimization;
	}

	// comment for setter related to [aemode] goes here
	@SetModelValue(key = "aemode")
	public void setExposureType(ExposureType exposureType) {
		this.exposureType = exposureType;
	}

	// comment for getter related to [aemode] goes here
	@GetModelValue(key = "aemode")
	public ExposureType getExposureType() {
		return exposureType;
	}

	// comment for setter related to [saturation] goes here
	@SetModelValue(key = "saturation")
	public void setSaturation(int saturation) {
		this.saturation = saturation;
	}

	// comment for getter related to [saturation] goes here
	@GetModelValue(key = "saturation")
	public int getSaturation() {
		return saturation;
	}

	// comment for setter related to [brightness] goes here
	@SetModelValue(key = "brightness")
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	// comment for getter related to [brightness] goes here
	@GetModelValue(key = "brightness")
	public int getBrightness() {
		return brightness;
	}

	// comment for setter related to [contrast] goes here
	@SetModelValue(key = "contrast")
	public void setContrast(int contrast) {
		this.contrast = contrast;
	}

	// comment for getter related to [contrast] goes here
	@GetModelValue(key = "contrast")
	public int getContrast() {
		return contrast;
	}

	// comment for setter related to [noise] goes here
	@SetModelValue(key = "noise")
	public void setNoise(int noise) {
		this.noise = noise;
	}

	// comment for getter related to [noise] goes here
	// @GetModelValue(key = "noise") - not used in set request
	public int getNoise() {
		return noise;
	}

	// comment for setter related to [hue] goes here
	@SetModelValue(key = "hue")
	public void setHue(int hue) {
		this.hue = hue;
	}

	// comment for getter related to [hue] goes here
	// @GetModelValue(key = "hue") - not used in set request
	public int getHue() {
		return hue;
	}

	// comment for setter related to [sharpness] goes here
	@SetModelValue(key = "sharpness")
	public void setSharpness(int sharpness) {
		this.sharpness = sharpness;
	}

	// comment for getter related to [sharpness] goes here
	@GetModelValue(key = "sharpness")
	public int getSharpness() {
		return sharpness;
	}

	// comment for setter related to [gc] goes here
	@SetModelValue(key = "gc")
	public void setGc(int gc) {
		this.gc = gc;
	}

	// comment for getter related to [gc] goes here
	@GetModelValue(key = "gc")
	public int getGc() {
		return gc;
	}

	// comment for setter related to [flip] goes here
	@SetModelValue(key = "flip")
	public void setFlipMode(StringState flipMode) {
		this.flipMode = flipMode;
	}

	// comment for getter related to [flip] goes here
	@GetModelValue(key = "flip")
	public StringState getFlipMode() {
		return flipMode;
	}

	// comment for setter related to [gamma] goes here
	@SetModelValue(key = "gamma")
	public void setGamma(int gamma) {
		this.gamma = gamma;
	}

	// comment for getter related to [gamma] goes here
	// @GetModelValue(key = "gamma") - not used in set request
	public int getGamma() {
		return gamma;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImageProperties [mirrorMode=");
		builder.append(mirrorMode);
		builder.append(", colorMode=");
		builder.append(colorMode);
		builder.append(", wideDynamicRange=");
		builder.append(wideDynamicRange);
		builder.append(", valueAE=");
		builder.append(valueAE);
		builder.append(", shutter=");
		builder.append(shutter);
		builder.append(", nightMode=");
		builder.append(nightMode);
		builder.append(", exposure=");
		builder.append(exposure);
		builder.append(", flashShutter=");
		builder.append(flashShutter);
		builder.append(", optimization=");
		builder.append(optimization);
		builder.append(", exposureType=");
		builder.append(exposureType);
		builder.append(", saturation=");
		builder.append(saturation);
		builder.append(", brightness=");
		builder.append(brightness);
		builder.append(", contrast=");
		builder.append(contrast);
		builder.append(", noise=");
		builder.append(noise);
		builder.append(", hue=");
		builder.append(hue);
		builder.append(", sharpness=");
		builder.append(sharpness);
		builder.append(", gc=");
		builder.append(gc);
		builder.append(", flipMode=");
		builder.append(flipMode);
		builder.append(", gamma=");
		builder.append(gamma);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brightness;
		result = prime * result + ((colorMode == null) ? 0 : colorMode.hashCode());
		result = prime * result + contrast;
		result = prime * result + exposure;
		result = prime * result + ((exposureType == null) ? 0 : exposureType.hashCode());
		result = prime * result + flashShutter;
		result = prime * result + ((flipMode == null) ? 0 : flipMode.hashCode());
		result = prime * result + gamma;
		result = prime * result + gc;
		result = prime * result + hue;
		result = prime * result + ((mirrorMode == null) ? 0 : mirrorMode.hashCode());
		result = prime * result + ((nightMode == null) ? 0 : nightMode.hashCode());
		result = prime * result + noise;
		result = prime * result + ((optimization == null) ? 0 : optimization.hashCode());
		result = prime * result + saturation;
		result = prime * result + sharpness;
		result = prime * result + shutter;
		result = prime * result + valueAE;
		result = prime * result + ((wideDynamicRange == null) ? 0 : wideDynamicRange.hashCode());
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
		ImageProperties other = (ImageProperties) obj;
		if (brightness != other.brightness)
			return false;
		if (colorMode != other.colorMode)
			return false;
		if (contrast != other.contrast)
			return false;
		if (exposure != other.exposure)
			return false;
		if (exposureType != other.exposureType)
			return false;
		if (flashShutter != other.flashShutter)
			return false;
		if (flipMode != other.flipMode)
			return false;
		if (gamma != other.gamma)
			return false;
		if (gc != other.gc)
			return false;
		if (hue != other.hue)
			return false;
		if (mirrorMode != other.mirrorMode)
			return false;
		if (nightMode != other.nightMode)
			return false;
		if (noise != other.noise)
			return false;
		if (optimization != other.optimization)
			return false;
		if (saturation != other.saturation)
			return false;
		if (sharpness != other.sharpness)
			return false;
		if (shutter != other.shutter)
			return false;
		if (valueAE != other.valueAE)
			return false;
		if (wideDynamicRange != other.wideDynamicRange)
			return false;
		return true;
	}

	
	
}
