package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public int add(String text) {
		if (isBlank(text)) {
			return 0;
		}

		String[] values = split(text);
		return sum(values);
	}

	private boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return text.split("[,:]");
	}

	private int sum(String[] values) {
		int sum = 0;
		for (String value : values) {
			sum += toInt(value);
		}
		return sum;
	}

	private static int toInt(String value) {
		int number = Integer.parseInt(value);

		if (number < 0) {
			throw new RuntimeException();
		}

		return number;
	}
}
