package com.sapient.calculator.operation;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFromPhraseOperation {
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
	
	public static String getDateFromPhrase(String phrase, Calendar cal) {
		int amount = 1;
		phrase = phrase.toLowerCase();

		if (phrase.contains(TODAY))
			return Conversion.dateToString(cal);
		else if (phrase.contains(TOMORROW) || phrase.contains(YESTERDAY)) {
			if (phrase.contains(YESTERDAY))
				amount *= -1;
			if (phrase.contains(AFTER) || phrase.contains(BEFORE))
				amount *= 2;
			cal.add(Calendar.DAY_OF_MONTH, amount);
		} else {
			if (phrase.contains(LAST) || phrase.contains(PREVIOUS) || phrase.contains(NEXT)) {
				if (phrase.contains(LAST) || phrase.contains(PREVIOUS))
					amount *= -1;
			} else {
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(phrase);
				if (matcher.find())
					amount *= Integer.parseInt(matcher.group(0));

				if (phrase.contains(EARLIER) || phrase.contains(BEFORE))
					amount *= -1;
			}

			if (phrase.contains(DAY)) {
				cal.add(Calendar.DAY_OF_MONTH, amount);
			} else if (phrase.contains(WEEK)) {
				cal.add(Calendar.WEEK_OF_YEAR, amount);
			} else if (phrase.contains(MONTH))
				cal.add(Calendar.MONTH, amount);
			else if (phrase.contains(YEAR))
				cal.add(Calendar.YEAR, amount);
		}

		return Conversion.dateToString(cal);
	}
}
