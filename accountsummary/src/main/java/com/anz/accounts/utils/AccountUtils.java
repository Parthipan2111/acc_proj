package com.anz.accounts.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public final class AccountUtils {

	public static String convetDateFormat(Date d1, int format) {
		String finalDate = "";
		DateFormat dateFromat = DateFormat.getDateInstance(format);
		finalDate = dateFromat.format(d1);

		return finalDate;

	}

	public static String textFormat(String text) {
		String convertedText = "";
		convertedText = text.replaceFirst("(\\d{3})(\\d{4})(\\d+)", "$1-$2-$3");
		return convertedText;
	}

	public static String numberFormat(BigDecimal number) {
		NumberFormat newFormat = NumberFormat.getCurrencyInstance();
		newFormat.setGroupingUsed(true);
		return newFormat.format(number);

	}
}