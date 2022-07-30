package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void missingNumber(int[] nums, int expected) {
        assertThat(new MissingNumber().missingNumber(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int []{3, 0, 1}, 2),
                Arguments.of(new int []{0, 1}, 2),
                Arguments.of(new int []{9,6,4,2,3,5,7,0,1}, 8)
        );
    }
}