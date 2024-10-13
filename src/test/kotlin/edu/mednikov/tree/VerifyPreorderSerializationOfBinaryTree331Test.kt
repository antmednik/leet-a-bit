package edu.mednikov.tree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class VerifyPreorderSerializationOfBinaryTree331Test {
    @ParameterizedTest
    @MethodSource("arguments")
    fun test(preorder: String, expected: Boolean) {
        assertEquals(
            expected,
            VerifyPreorderSerializationOfBinaryTree331().isValidSerialization(preorder)
        )
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                Arguments.of("1,#", false),
                Arguments.of("9,#,#,1", false),
                Arguments.of("1", false),
            )
        }
    }
}