package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyAtoiTest {

    @ParameterizedTest
    @MethodSource("arguments")
    public void test1(String input, int expected) {
        assertThat(new MyAtoi().myAtoi(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        // Integer.MAX_VALUE = 2 147 483 647
        // Integer.MIN_VALUE = -2 147 483 648
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("-1", -1),
                Arguments.of("    -00000001", -1),
                Arguments.of("-01324000", -1324000),
                Arguments.of("-1123 asdasdasd", -1123),
                Arguments.of("78683 asdasdasd", 78683),
                Arguments.of("1234567", 1234567),
                Arguments.of("-987654", -987654),
                Arguments.of("2147483646", 2147483646),
                Arguments.of("2147483647", Integer.MAX_VALUE),
                Arguments.of("2147483648", Integer.MAX_VALUE),
                Arguments.of("999999999999 ksljdaljs", Integer.MAX_VALUE),
                Arguments.of("-2147483647", -2147483647),
                Arguments.of("-2147483648", Integer.MIN_VALUE),
                Arguments.of("-2147483649", Integer.MIN_VALUE),
                Arguments.of("-44444444444444 sdasd", Integer.MIN_VALUE)
        );
    }
}
