package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroOneMatrixTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void updateMatrix(int[][] input, int[][] expected) {
        assertThat(new ZeroOneMatrix().updateMatrix(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 0},
                                new int[]{0, 0, 0},
                        },
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 0},
                                new int[]{0, 0, 0},
                        }),
                Arguments.of(
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 0},
                                new int[]{1, 1, 1},
                        },
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 0},
                                new int[]{1, 2, 1},
                        }),
                Arguments.of(
                        new int[][]{
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0}
                        },
                        new int[][]{
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0},
                                new int[]{0,1,0}
                        }),
                Arguments.of(
                        new int[][]{
                                new int[]{1,0,1,1,0,0,1,0,0,1},
                                new int[]{0,1,1,0,1,0,1,0,1,1},
                                new int[]{0,0,1,0,1,0,0,1,0,0},
                                new int[]{1,0,1,0,1,1,1,1,1,1},
                                new int[]{0,1,0,1,1,0,0,0,0,1},
                                new int[]{0,0,1,0,1,1,1,0,1,0},
                                new int[]{0,1,0,1,0,1,0,0,1,1},
                                new int[]{1,0,0,0,1,1,1,1,0,1},
                                new int[]{1,1,1,1,1,1,1,0,1,0},
                                new int[]{1,1,1,1,0,1,0,0,1,1}
                        },
                        new int[][]{
                                new int[]{1,0,1,1,0,0,1,0,0,1},
                                new int[]{0,1,1,0,1,0,1,0,1,1},
                                new int[]{0,0,1,0,1,0,0,1,0,0},
                                new int[]{1,0,1,0,1,1,1,1,1,1},
                                new int[]{0,1,0,1,1,0,0,0,0,1},
                                new int[]{0,0,1,0,1,1,1,0,1,0},
                                new int[]{ 0, 1, 0, 1, 0,  1, 0, 0, 1, 1},
                                new int[]{ 1, 0, 0, 0, 1,  2, 1, 1, 0, 1},
                                new int[]{ 2, 1, 1, 1, 1,  2, 1, 0, 1, 0},
                                new int[]{ 3, 2, 2, 1, 0,  1, 0, 0, 1, 1}
                        }
                )
        );
    }
}