package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;
import io.github.d2edev.ccc.objects.support.Status;
import io.github.d2edev.ccc.objects.support.TimeZone;

public class ServerTime {
	//reply example
	//var time="20171108095655";
	// var timeZone="America/New_York";
	// var dstmode="on";
	
//	Current date and time
//	[yyyy][mm][dd][hh][mm][ss]
	@QueryParameter(get="time")
	private String time;
	
	//time zone
	@QueryParameter(get="timeZone",set="timezone")
	private TimeZone timeZone;
	
	//daylight saving
	@QueryParameter(get="dstmode")	
	private Status daylightModeStatus;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public Status getDaylightModeStatus() {
		return daylightModeStatus;
	}

	public void setDaylightModeStatus(Status daylightModeStatus) {
		this.daylightModeStatus = daylightModeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerTime [time=");
		builder.append(time);
		builder.append(", timeZone=");
		builder.append(timeZone);
		builder.append(", daylightModeStatus=");
		builder.append(daylightModeStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
}
