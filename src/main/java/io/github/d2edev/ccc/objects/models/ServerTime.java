package io.github.d2edev.ccc.objects.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import io.github.d2edev.ccc.objects.base.GetModelValue;
import io.github.d2edev.ccc.objects.base.ModelType;
import io.github.d2edev.ccc.objects.base.SetModelValue;
import io.github.d2edev.ccc.objects.support.Status;
import io.github.d2edev.ccc.objects.support.CameraTimeZone;

@ModelType(ModelType.COMPLEX)
public class ServerTime {
	// reply example
	// var timeZone="America/New_York";
	// var dstmode="on";

	// Current date and time
	private Calendar cal=Calendar.getInstance();
	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd Z HH:mm:ss");


	// daylight saving
	private Status daylightModeStatus;

	@GetModelValue(key = "time")
	public String getTime() {
		if (cal == null)
			return null;
		return outputFormat.format(cal.getTime());
	}

	// data comes as
	// var time="20171108095655";
	// [yyyy][mm][dd][hh][mm][ss]
	@SetModelValue(key = "time")
	public void setTime(String time) throws ParseException {
		cal.setTime(inputFormat.parse(time));
	}

	// !!! pls pay attention to parameter names diffenrece
	// in getter and setter
	@GetModelValue(key = "timezone")
	public String getTimeZone() {
		return cal.getTimeZone().getID();
		
	}

	@SetModelValue(key = "timeZone")
	public void setTimeZone(CameraTimeZone timeZone) {
		TimeZone tz=TimeZone.getTimeZone(timeZone.stringValue());
		cal.setTimeZone(tz);
	}

	@GetModelValue(key = "dstmode")
	public Status getDaylightModeStatus() {
		return daylightModeStatus;
	}

	@SetModelValue(key = "dstmode")
	public void setDaylightModeStatus(Status daylightModeStatus) {
		this.daylightModeStatus = daylightModeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerTime [time=");
		builder.append(stringFormat.format(cal.getTime()));
		builder.append(", timeZone=");
		builder.append(cal.getTimeZone().getID());
		builder.append(", daylightModeStatus=");
		builder.append(daylightModeStatus);
		builder.append("]");
		return builder.toString();
	}

}
