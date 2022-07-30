package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsInStringIIITest {

    @ParameterizedTest
    @MethodSource("arguments")
    void reverseWords(String input, String expected) {
        assertThat(new ReverseWordsInStringIII().reverseWords(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                Arguments.of("God Ding", "doG gniD")
        );
    }
}