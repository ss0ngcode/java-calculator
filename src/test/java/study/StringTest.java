package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void commaTest() {
		//given
		String includeComma = "1,2";
		String excludeComma = "1";

		//when
		String[] strArr1 = includeComma.split(",");
		String[] strArr2 = excludeComma.split(",");

		//then
		assertThat(strArr1).contains("1", "2");
		assertThat(strArr2).containsExactly("1");
	}

	@Test
	void substringTest() {
		//given
		String str = "(1,2)";

		//when
		String substringStr = str.substring(1, 4);

		//then
		assertThat(substringStr).isEqualTo("1,2");
	}

	@DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
	@Test
	void charAtTest() {
		//given
		String str = "abc";

		//when

		//then
		assertThatThrownBy(() -> {
			str.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");
	}
}
