package io.github.d2edev.ccc.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.CameraTimeZone;
import io.github.d2edev.ccc.enums.StringState;

@Model(Model.COMPLEX)
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
	private StringState daylightModeStatus;

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

	// !!! pls pay attention to parameter names difference
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
	public StringState getDaylightModeStatus() {
		return daylightModeStatus;
	}

	@SetModelValue(key = "dstmode")
	public void setDaylightModeStatus(StringState daylightModeStatus) {
		this.daylightModeStatus = daylightModeStatus;
	}

	
	public void setDateTime(Date dateTime){
		cal.setTime(dateTime);
	}
	
	public Date getDateTime(){
		return cal.getTime();
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
