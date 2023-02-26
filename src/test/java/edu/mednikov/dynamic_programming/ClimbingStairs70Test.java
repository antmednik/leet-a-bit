package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairs70Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void climbStairs(int n, int expectedCount) {
        assertThat(new ClimbingStairs70().climbStairs(n)).isEqualTo(expectedCount);
    }
}