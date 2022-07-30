package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationInStringTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void checkInclusion(String s1, String s2, boolean expected) {
        boolean actual = new PermutationInString().checkInclusion(s1, s2);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false)
        );
    }
}