package com.sapient.calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DateTimeCalculatorUtils {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

	public static String addDates(Calendar cal1, Calendar cal2) {
		cal1.add(Calendar.DATE, cal2.get(Calendar.DATE));
		cal1.add(Calendar.MONTH, (cal2.get(Calendar.MONTH) + 1));
		cal1.add(Calendar.YEAR, cal2.get(Calendar.YEAR));
		return dateToString(cal1);
	}

	public static String subDates(Calendar cal1, Calendar cal2) {
		LocalDate date1, date2;
		if (cal1.before(cal2)) {
			date1 = LocalDateTime.ofInstant(cal1.toInstant(), cal1.getTimeZone().toZoneId()).toLocalDate();
			date2 = LocalDateTime.ofInstant(cal2.toInstant(), cal2.getTimeZone().toZoneId()).toLocalDate();
		} else {
			date1 = LocalDateTime.ofInstant(cal2.toInstant(), cal2.getTimeZone().toZoneId()).toLocalDate();
			date2 = LocalDateTime.ofInstant(cal1.toInstant(), cal1.getTimeZone().toZoneId()).toLocalDate();
		}

		return "Days: " + ChronoUnit.DAYS.between(date1, date2) + "\tWeeks: " + ChronoUnit.WEEKS.between(date1, date2)
				+ "\tMonths: " + ChronoUnit.MONTHS.between(date1, date2);
	}

	public static String addSubDays(Calendar cal, int days) {
		cal.add(Calendar.DAY_OF_MONTH, days);
		return dateToString(cal);
	}

	public static String addSubWeeks(Calendar cal, int weeks) {
		cal.add(Calendar.WEEK_OF_YEAR, weeks);
		return dateToString(cal);
	}

	public static String addSubMonths(Calendar cal, int months) {
		cal.add(Calendar.MONTH, months);
		return dateToString(cal);
	}

	public static String addSubYears(Calendar cal, int years) {
		cal.add(Calendar.YEAR, years);
		return dateToString(cal);
	}

	public static String getDay(Calendar cal) {
		return new SimpleDateFormat("EEEE").format(cal.getTime());
	}

	public static String getWeekNo(Calendar cal) {
		return String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
	}

	public static Calendar stringToDate(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}

	protected static String dateToString(Calendar cal) {
		return (cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR));
	}
}
