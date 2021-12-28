package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IncreasingTripletSubsequenceTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void test(int[] nums, boolean expected) {
        assertThat(new IncreasingTripletSubsequence().increasingTriplet(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
                Arguments.of(new int[]{2, 1, 5, 0, 4, 6}, true)
        );
    }
}