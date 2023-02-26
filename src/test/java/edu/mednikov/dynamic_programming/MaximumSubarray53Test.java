package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSubarray53Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-2, -1}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void maxSubArray(int[] nums, int expected) {
        assertThat(new MaximumSubarray53().maxSubArray(nums)).isEqualTo(expected);
    }
}