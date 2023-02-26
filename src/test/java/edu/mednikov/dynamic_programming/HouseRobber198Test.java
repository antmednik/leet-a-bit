package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HouseRobber198Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void rob(int nums[], int expectedSum) {
        assertThat(new HouseRobber198().rob(nums)).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12),
                Arguments.of(new int[]{1, 3, 1}, 3),
                Arguments.of(new int[]{2, 1, 1, 2}, 4)
        );
    }
}