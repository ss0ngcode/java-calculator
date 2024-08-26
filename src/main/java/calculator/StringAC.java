package calculator;

import java.util.Arrays;
import java.util.List;

public class StringAC {
	public static int cal(String text) {

		String commonDelimiter = ",|:";
		String[] customResult = new String[2];

		if (text.startsWith("//")) {
			customResult = customDelimiter(text);
			commonDelimiter += "|" + customResult[0];
			text = customResult[1];
		}

		List<String> result = Arrays.asList(text.split(commonDelimiter));

		int sum = 0;

		for (String s : result) {
			sum += Integer.parseInt(s);
		}

		return sum;
	}

	private static String[] customDelimiter(String text) {
		int endIndex = text.indexOf('\n');
		String customDelimiter = text.substring(2, endIndex);
		String subText = text.substring(endIndex + 1);

		String[] result = new String[2];
		result[0] = customDelimiter;
		result[1] = subText;

		return result; //커스텀 구분자 리턴
	}
}
