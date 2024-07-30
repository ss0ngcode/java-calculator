package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 메소드를 활용해 Set의 크기를 확인")
	@Test
	void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set에 해당 값이 존재하는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setValueContainsTest(int input) {
		assertTrue(numbers.contains(input));
	}

	@DisplayName("Set에 해당 값이 존재하는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
	void setValueContainsResultBooleanTest(int input, boolean predictionResult) {
		boolean result = numbers.contains(input);

		assertEquals(predictionResult, result);
	}
}
