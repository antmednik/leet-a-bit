package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SquaresOfASortedArrayTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void sortedSquares(int[] nums, int[] expected) {
        var sut = new SquaresOfASortedArray();
        assertThat(sut.sortedSquares(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }
}