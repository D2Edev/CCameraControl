package io.github.d2edev.ccc.objects.support;

import io.github.d2edev.ccc.objects.base.ValueProvider;

public enum TimeZone implements ValueProvider{
	
	ETC_GMT_12 ("Etc/GMT-12","(GMT-12:00) date line west"),
	PACIFIC_APIA ("Pacific/Apia","(GMT-11:00) Midway, Samoan Islands"),
	PACIFIC_HONOLULU ("Pacific/Honolulu","(GMT-10:00) Hawaii"),
	AMERICA_ANCHORAGE ("America/Anchorage","(GMT-09:00) Alaska"),
	AMERICA_LOSANGELES ("America/Los_Angeles","(GMT-08:00) Pacific Time (US and Canada)"),
	AMERICA_DENVER ("America/Denver","(GMT-07:00) Mountain Time (US and Canada)"),
	AMERICA_TEGUCIGALPA ("America/Tegucigalpa","(GMT-07:00) Chihuahua,La Paz, Mazatlan"),
	AMERICA_PHOENIX ("America/Phoenix","(GMT-07:00) Arizona"),
	AMERICA_WINNIPEG ("America/Winnipeg","(GMT-06:00) Saskatchewan"),
	AMERICA_MEXICOCITY ("America/Mexico_City","(GMT-06:00) Guadalajara, Mexico City, Monterrey"),
	AMERICA_CHICAGO ("America/Chicago","(GMT-06:00) Central Time (US and Canada)"),
	AMERICA_COSTARICA ("America/Costa_Rica","(GMT-06:00) Central America"),
	AMERICA_INDIANAPOLIS ("America/Indianapolis","(GMT-05:00) Indiana (east)"),
	AMERICA_NEWYORK ("America/New_York","(GMT-05: 00) Eastern Time (US and Canada)"),
	AMERICA_BOGOTA ("America/Bogota","(GMT-05: 00) Bogota, Lima, Rio Branco"),
	AMERICA_SANTIAGO ("America/Santiago","(GMT-04: 00) Santiago"),
	AMERICA_CARACAS ("America/Caracas","(GMT-04: 00) La Paz"),
	AMERICA_MONTREAL ("America/Montreal","(GMT-04: 00) Atlantic Time (Canada)"),
	AMERICA_STJOHNS ("America/St_Johns","(GMT-03: 30) Newfoundland"),
	AMERICA_THULE ("America/Thule","(GMT-03: 00) Greenland"),
	AMERICA_BUENOSAIRES ("America/Buenos_Aires","(GMT-03: 00) Buenos Aires, Georgetown"),
	AMERICA_SAOPAULO ("America/Sao_Paulo","(GMT-03: 00) Brasilia"),
	ATLANTIC_SOUTHGEORGIA ("Atlantic/South_Georgia","(GMT-02: 00) Mid-Atlantic"),
	ATLANTIC_CAPEVERDE ("Atlantic/Cape_Verde","(GMT-01: 00) Cape Verde Islands"),
	ATLANTIC_AZORES ("Atlantic/Azores","(GMT-01: 00) Azores"),
	EUROPE_DUBLIN("Europe/Dublin","(GMT) Greenwich Mean Time: Dublin, Edinburgh, London, Lisbon"),
	AFRICA_CASABLANCA("Africa/Casablanca","(GMT) Casablanca, Monrovia, Reykjavik"),
	EUROPE_AMSTERDAM("Europe/Amsterdam","(GMT +01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna"),
	EUROPE_BELGRADE("Europe/Belgrade","(GMT +01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague"),
	EUROPE_BRUSSELS ("Europe/Brussels","(GMT +01:00) Brussels, Copenhagen, Madrid, Paris"),
	EUROPE_WARSAW ("Europe/Warsaw","(GMT +01:00) Sarajevo, Skopje, Warsaw, Zagreb"),
	AFRICA_LAGOS ("Africa/Lagos","(GMT +01:00) West Central"),
	EUROPE_ATHENS ("Europe/Athens","(GMT +02:00) Athens, Istanbul, Minsk"),
	EUROPE_BUCHAREST ("Europe/Bucharest","(GMT +02:00) Bucharest"),
	AFRICA_CAIRO ("Africa/Cairo","(GMT +02:00) Cairo"),
	AFRICA_HARARE ("Africa/Harare","(GMT +02:00) Harare, Pretoria"),
	EUROPE_HELSINKI ("Europe/Helsinki","(GMT +02:00) Helsinki, Kiev, Riga, Sofia, Tallinn, Vilnius"),
	ASIA_JERUSALEM ("Asia/Jerusalem","(GMT +02:00) Jerusalem"),
	ASIA_BAGHDAD ("Asia/Baghdad","(GMT +03:00) Baghdad"),
	ASIA_KUWAIT ("Asia/Kuwait","(GMT +03:00) Kuwait, Riyadh"),
	EUROPE_MOSCOW ("Europe/Moscow","(GMT +03:00) Moscow, St. Petersburg, Volgograd"),
	AFRICA_NAIROBI ("Africa/Nairobi","(GMT +03:00) Nairobi"),
	ASIA_TEHRAN ("Asia/Tehran","(GMT +03:30) Tehran"),
	ASIA_DUBAI ("Asia/Dubai","(GMT +04:00) Abu Dhabi, Muscat"),
	ASIA_BAKU ("Asia/Baku","(GMT +04:00) Baku, Tbilisi, Yerevan"),
	ASIA_KABUL ("Asia/Kabul","(GMT +04:30) Kabul"),
	ASIA_YEKATERINBURG ("Asia/Yekaterinburg","(GMT +05:00) Ekaterinburg"),
	ASIA_KARACHI ("Asia/Karachi","(GMT +05:00) Islamabad, Karachi, Tashkent"),
	ASIA_CALCUTTA ("Asia/Calcutta","(GMT +05:30) Madras, Calcutta, Mumbai, New Delhi"),
	ASIA_KATMANDU ("Asia/Katmandu","(GMT +05:45) Kathmandu"),
	ASIA_ALMATY ("Asia/Almaty","(GMT +06:00) Almaty, Novosibirsk"),
	ASIA_DHAKA ("Asia/Dhaka","(GMT +06:00) Astana, Dhaka"),
	ASIA_COLOMBO ("Asia/Colombo","(GMT +06:00) Colombo"),
	ASIA_RANGOON ("Asia/Rangoon","(GMT +06:30) Rangoon"),
	ASIA_BANGKOK ("Asia/Bangkok","(GMT +07:00) Bangkok, Hanoi, Jakarta"),
	ASIA_KRASNOYARSK ("Asia/Krasnoyarsk","(GMT +07:00) Krasnoyarsk"),
	ASIA_HONGKONG ("Asia/Hong_Kong","(GMT +08:00) Beijing, Chongqing, Hong Kong, Urumqi"),
	ASIA_IRKUTSK ("Asia/Irkutsk","(GMT +08:00) Irkutsk, Ulaanbaatar map"),
	ASIA_KUALALUMPUR ("Asia/Kuala_Lumpur","(GMT +08:00) Kuala Lumpur, Singapore"),
	AUSTRALIA_PERTH ("Australia/Perth","(GMT +08:00) Perth"),
	ASIA_TAIPEI ("Asia/Taipei","(GMT +08:00) Taipei"),
	ASIA_TOKYO ("Asia/Tokyo","(GMT +09:00) Osaka, Sapporo, Tokyo"),
	ASIA_SEOUL ("Asia/Seoul","(GMT +09:00) Seoul"),
	ASIA_YAKUTSK ("Asia/Yakutsk","(GMT +09:00) Yakutsk"),
	AUSTRALIA_ADELAIDE ("Australia/Adelaide","(GMT +09:30) Adelaide"),
	AUSTRALIA_BRISBANE ("Australia/Brisbane","(GMT +10:00) Brisbane"),
	AUSTRALIA_SYDNEY ("Australia/Sydney","(GMT +10:00) Canberra, Melbourne, Sydney"),
	PACIFIC_GUAM ("Pacific/Guam","(GMT +10:00) Guam, Port Moresby"),
	AUSTRALIA_HOBART ("Australia/Hobart","(GMT +10:00) Hobart"),
	ASIA_VLADIVOSTOK ("Asia/Vladivostok","(GMT +10:00) Vladivostok"),
	ASIA_MAGADAN ("Asia/Magadan","(GMT +11:00) Majia Disi Qin, Solomon Islands, New Caledoniya"),
	PACIFIC_AUCKLAND ("Pacific/Auckland","(GMT +12:00) Auckland, Wellington"),
	PACIFIC_FIJI ("Pacific/Fiji","(GMT +12:00) Fiji, Kamchatka, Marshall Islands"),
	PACIFIC_TONGATAPU ("Pacific/Tongatapu","(GMT +13:00) Nuku'alofa");


	private TimeZone(String id,String details) {
		this.id = id;
	}

	private String id;
	private String details;

	public Object value() {
		return id;
	}
	
	@Override
	public String stringValue() {
		return id;
	}
}