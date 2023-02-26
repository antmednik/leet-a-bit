package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParentheses22Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void generateParenthesis(int n, List<String> expected) {
        var actual = new GenerateParentheses22().generateParenthesis(n);
        assertThat(sorterList(actual)).isEqualTo(sorterList(expected));
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, List.of("()")),
                Arguments.of(2, List.of("()()", "(())")),
                Arguments.of(3, List.of("((()))","(()())","(())()","()(())","()()()")),
                Arguments.of(4, List.of("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"))
        );
    }

    private static List<String> sorterList(List<String> input) {
        var nl = new ArrayList<>(input);
        nl.sort(String::compareTo);
        return nl;
    }
}