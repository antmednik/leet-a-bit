package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InterleavingString97Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("", "", "", true),
                Arguments.of("a", "a", "aa", true),
                Arguments.of("ab", "cd", "acbd", true),
                Arguments.of("aabcc", "dbbca", "aadbbcbcac", true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void isInterleave(String s1, String s2, String s3, boolean expected) {
        assertThat(new InterleavingString97().isInterleave(s1, s2, s3)).isEqualTo(expected);
    }
}