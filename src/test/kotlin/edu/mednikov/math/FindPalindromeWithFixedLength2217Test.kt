package edu.mednikov.math

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertContentEquals

class FindPalindromeWithFixedLength2217Test {

    @ParameterizedTest
    @MethodSource("arguments")
    fun kthPalindrome(expected: LongArray, queries: IntArray, intLength: Int) {
        assertContentEquals(
            expected,
            FindPalindromeWithFixedLength2217().kthPalindrome(queries, intLength)
        )
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(longArrayOf(101, 111, 121, 131, 141, 999), intArrayOf(1, 2, 3, 4, 5, 90), 3),
                Arguments.of(longArrayOf(1111, 1331, 1551), intArrayOf(2, 4, 6), 4),
                Arguments.of(
                    longArrayOf(2, -1, 8, -1, -1, -1, -1, 9, 7, 6),
                    intArrayOf(2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6),
                    1
                ),
                Arguments.of(
                    longArrayOf(
                        -1,
                        100084480001,
                        100043340001,
                        100089980001,
                        -1,
                        -1,
                        -1,
                        100048840001,
                        -1,
                        100044440001
                    ),
                    intArrayOf(256965477, 85, 44, 90, 519833663, 813131855, 658305751, 49, 962390851, 45),
                    12
                ),

                )
        }
    }
}