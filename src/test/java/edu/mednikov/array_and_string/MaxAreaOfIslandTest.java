package edu.mednikov.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxAreaOfIslandTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }, 6),
                Arguments.of(new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 1}
                }, 3),
                Arguments.of(new int[][]{
                        new int[]{1, 1},
                        new int[]{0, 1},
                        new int[]{1, 1},
                }, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void maxAreaOfIsland(int[][] grid, int expectedMaxArea) {
        assertThat(new MaxAreaOfIsland().maxAreaOfIsland(grid)).isEqualTo(expectedMaxArea);
    }
}