package com.sapient.calculator;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToDate extends DateTimeCalculatorUtils{
	private static final String TODAY = "today";
	private static final String TOMORROW = "tomorrow";
	private static final String YESTERDAY = "yesterday";
	private static final String AFTER = "after";
	private static final String BEFORE = "before";
	private static final String DAY = "day";
	private static final String WEEK = "week";
	private static final String MONTH = "month";
	private static final String YEAR = "year";
	private static final String LAST = "last";
	private static final String PREVIOUS = "previous";
	private static final String NEXT = "next";
	private static final String EARLIER = "earlier";

	public static String convert(String str) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(new Date());

		int amount = 1;
		str = str.toLowerCase();

		if (str.contains(TODAY))
			return dateToString(cal);
		else if (str.contains(TOMORROW) || str.contains(YESTERDAY)) {
			if (str.contains(YESTERDAY))
				amount *= -1;
			if (str.contains(AFTER) || str.contains(BEFORE))
				amount *= 2;
			str = addSubDays(cal, amount);
		} else {
			if (str.contains(LAST) || str.contains(PREVIOUS) || str.contains(NEXT)) {
				if (str.contains(LAST) || str.contains(PREVIOUS))
					amount *= -1;
			} else {
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(str);
				if (matcher.find())
					amount *= Integer.parseInt(matcher.group(0));

				if (str.contains(EARLIER) || str.contains(BEFORE))
					amount *= -1;
			}

			if (str.contains(DAY)) {
				str = addSubDays(cal, amount);
			} else if (str.contains(WEEK)) {
				str = addSubWeeks(cal, amount);
			} else if (str.contains(MONTH))
				str = addSubMonths(cal, amount);
			else if (str.contains(YEAR))
				str = addSubYears(cal, amount);
		}

		return str;
	}

}
