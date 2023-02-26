package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameII45Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void jump(int[] nums, int expectedJumpCount) {
        assertThat(new JumpGameII45().jump(nums)).isEqualTo(expectedJumpCount);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2)
        );
    }
}