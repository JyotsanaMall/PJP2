package com.sapient.calculator.operation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DayOfWeekOperation {
	public static String getDayOfWeek(Calendar cal) {
		return new SimpleDateFormat("EEEE").format(cal.getTime());
	}
}
