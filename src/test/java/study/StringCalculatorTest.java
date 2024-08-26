package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	/**
	 *
	 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
	 - (예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)

	 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n"사이에 위치하는 문자를 커스텀 구분자로 사용한다.
	 - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;) 이며 결과값은 6이 반환되어야 한다.

	 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
	 */
	private StringCalculator stringCalculator;

	@BeforeEach
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

/*	@DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
	@ParameterizedTest
	// @CsvSource(value = {";0", "1,2;3", "1,2:3;6"}, delimiter = ';')
	void commaAndColonTextAddTest(String input, int expected) {
		//given
		String text = input;

		//when
		int result = stringCalculator.add(text);

		//then
		assertEquals(expected, result);
	}*/

	@DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\"사이에 위치하는 문자를 커스텀 구분자로 사용")
	@Test
	void customDelimiterAddTest() {
		//given
		String text = "//;\n1;2;3";

		//when
		int result = stringCalculator.add(text);

		//then
		assertEquals(6, result);
	}

	@DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw")
	@Test
	void throwRuntimeExceptionTest() {
		//given
		String text = "-1,2:3";

		//when

		//then
		assertThrows(RuntimeException.class, () -> stringCalculator.add(text));
	}
}
