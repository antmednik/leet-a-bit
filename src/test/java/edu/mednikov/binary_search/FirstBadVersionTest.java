package edu.mednikov.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstBadVersionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void firstBadVersion(int n, int bad) {
        var sut = new FirstBadVersion(bad);

        assertThat(sut.firstBadVersion(n)).isEqualTo(bad);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(5, 4),
                Arguments.of(1, 1),
                Arguments.of(2, 2)

        );
    }
}