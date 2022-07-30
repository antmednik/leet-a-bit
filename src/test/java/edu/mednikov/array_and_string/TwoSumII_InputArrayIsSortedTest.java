package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumII_InputArrayIsSortedTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void twoSum(int[] nums, int t, int[] expected) {
        var sut = new TwoSumII_InputArrayIsSorted();
        assertThat(sut.twoSum(nums, t)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2,3,4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}