package edu.mednikov.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchInsertPositionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void firstBadVersion(int[] nums, int target, int expected) {
        var sut = new SearchInsertPosition();

        assertThat(sut.searchInsert(nums, target)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{1, 3, 5, 6}, 0, 0)
        );
    }
}