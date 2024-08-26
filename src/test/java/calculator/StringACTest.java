package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringACTest {

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "//;\n1;2;3"})
		// @CsvSource(value = {"1,2,3?6", "//;\n2;2;3?7"}, delimiter = '?')
	void 커스텀_구분자(String string) {
		int result = StringAC.cal(string);

		assertThat(result).isEqualTo(6);
	}
}
