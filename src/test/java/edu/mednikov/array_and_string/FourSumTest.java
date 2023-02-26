package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FourSumTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void fourSum(int[] nums, int target, List<List<Integer>> expected) {
        assertThat(new FourSum().fourSum(nums, target)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1,0,-1,0,-2,2},
                        0,
                        List.of(
                                List.of(-2,0,0,2),
                                List.of(-2,-1,1,2),
                                List.of(-1,0,0,1))),
                Arguments.of(new int[]{2,2,2,2}, 8, List.of(
                                List.of(2,2,2,2))),
                Arguments.of(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296, List.of())
        );
    }
}