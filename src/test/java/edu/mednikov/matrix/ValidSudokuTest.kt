package edu.mednikov.matrix

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidSudokuTest {

    private fun arguments(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(arrayOf(
                charArrayOf('5','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9')
            ), true),
            Arguments.of(arrayOf(
                charArrayOf('8','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9')
            ), false)
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun isValidSudoku(board: Array<CharArray>, expected: Boolean) {
        assertThat(ValidSudoku().isValidSudoku(board)).isEqualTo(expected)
    }
}