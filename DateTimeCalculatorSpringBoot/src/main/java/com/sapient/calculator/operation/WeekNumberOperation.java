package com.sapient.calculator.operation;

import java.util.Calendar;

public class WeekNumberOperation {
	public static int getWeekNumber(Calendar cal) {
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
}
