package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerToRomanTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void intToRoman(int input, String expected) {
        assertThat(new IntegerToRoman().intToRoman(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(1, "I"),
                Arguments.of(3999, "MMMCMXCIX"),
                Arguments.of(1991, "MCMXCI")
        );
    }
}