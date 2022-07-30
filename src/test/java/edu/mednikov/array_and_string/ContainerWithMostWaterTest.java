package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{2, 3, 10, 5, 7, 8, 9}, 36),
                Arguments.of(new int[]{2, 3, 4, 5, 18, 17, 6}, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void maxArea(int[] height, int expected) {
        assertThat(new ContainerWithMostWater().maxArea(height)).isEqualTo(expected);
    }
}