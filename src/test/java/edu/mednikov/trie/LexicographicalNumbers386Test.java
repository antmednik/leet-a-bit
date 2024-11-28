package edu.mednikov.trie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LexicographicalNumbers386Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{1, 2}),
                Arguments.of(13, new int[]{1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(24, new int[]{1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 3, 4, 5, 6, 7, 8, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void lexicalOrder(int n, int[] expected) {
        assertArrayEquals(
                expected,
                new LexicographicalNumbers386().lexicalOrder(n).stream().mapToInt(i -> i).toArray()
        );
    }
}