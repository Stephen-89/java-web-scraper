package com.stephen.scraper;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String formatDate(String date) {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return zonedDateTime.format(formatter);
	}
	
}
