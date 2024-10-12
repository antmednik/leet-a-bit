package edu.mednikov.generation

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class GenerateBinaryStringsWithoutAdjacentZeros3211Test {

    @ParameterizedTest
    @MethodSource("arguments")
    fun test(n: Int, expected: Set<String>) {
        assertEquals(
            expected,
            GenerateBinaryStringsWithoutAdjacentZeros3211().validStrings(n).toSet()
        )
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, setOf("0", "1")),
                Arguments.of(2, setOf("01", "10", "11")),
                Arguments.of(3, setOf("010", "011", "101", "110", "111")),
                Arguments.of(4, setOf("0101", "0110", "0111", "1010", "1011", "1101", "1110", "1111")),
            )
        }
    }
}