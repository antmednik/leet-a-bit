package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PascalSTriangle118Test {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        1,
                        List.of(
                                List.of(1))
                ),
                Arguments.of(
                        2,
                        List.of(
                                List.of(1),
                                List.of(1, 1)
                        )
                ),
                Arguments.of(
                        3,
                        List.of(
                                List.of(1),
                                List.of(1, 1),
                                List.of(1, 2, 1)
                        )
                ),
                Arguments.of(
                        4,
                        List.of(
                                List.of(1),
                                List.of(1, 1),
                                List.of(1, 2, 1),
                                List.of(1, 3, 3, 1)
                        )
                ),
                Arguments.of(
                        5,
                        List.of(
                                List.of(1),
                                List.of(1, 1),
                                List.of(1, 2, 1),
                                List.of(1, 3, 3, 1),
                                List.of(1, 4, 6, 4, 1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void generate(int numRows, List<List<Integer>> expected) {
        assertThat(new PascalSTriangle118().generate(numRows)).isEqualTo(expected);
    }
}