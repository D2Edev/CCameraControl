package io.github.d2edev.ccc.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
	private ZoneId zid;
	private LocalDateTime datetime;
	private DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	private DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");

	// daylight saving
	private StringState daylightModeStatus;

	@GetModelValue(key = "time")
	public String getDateTimeSpecial() {
		return datetime.format(outputFormatter);
	}

	// data comes as
	// var time="20171108095655";
	// [yyyy][mm][dd][hh][mm][ss]
	@SetModelValue(key = "time")
	public void setDateTimeSpecial(String time) throws ParseException {
		datetime = LocalDateTime.parse(time, inputFormatter);
	}

	// !!! pls pay attention to parameter names difference
	// in getter and setter
	@GetModelValue(key = "timezone")
	public String getTimeZone() {
		return zid.getId();

	}

	@SetModelValue(key = "timeZone")
	public void setTimeZone(String timeZone) {
		zid = ZoneId.of(timeZone);
	}

	@GetModelValue(key = "dstmode")
	public StringState getDaylightModeStatus() {
		return daylightModeStatus;
	}

	@SetModelValue(key = "dstmode")
	public void setDaylightModeStatus(StringState daylightModeStatus) {
		this.daylightModeStatus = daylightModeStatus;
	}

	public void setDateTime(ZonedDateTime zdt) {
		zid = zdt.getZone();
		datetime = zdt.toLocalDateTime();
	}

	public ZonedDateTime getDateTime() {
		return datetime.atZone(zid);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerTime [zid=");
		builder.append(zid);
		builder.append(", datetime=");
		builder.append(datetime);
		builder.append(", daylightModeStatus=");
		builder.append(daylightModeStatus);
		builder.append("]");
		return builder.toString();
	}

}
