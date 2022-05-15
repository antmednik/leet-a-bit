package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void rotate(int[] nums, int k, int[] expected) {
        var sut = new RotateArray();
        sut.rotate(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4}),
                Arguments.of(new int[]{-1,-100,3,99}, 2, new int[]{3,99,-1,-100})
        );
    }
}