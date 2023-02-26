package edu.mednikov.dynamic_programming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairs746Test {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1,100,1,1,1,100,1,1,100,1}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void minCostClimbingStairs(int[] cost, int expected) {
        assertThat(new MinCostClimbingStairs746().minCostClimbingStairs(cost)).isEqualTo(expected);
    }
}