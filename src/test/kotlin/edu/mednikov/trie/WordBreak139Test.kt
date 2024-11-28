package edu.mednikov.trie

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WordBreak139Test {

    @ParameterizedTest
    @MethodSource("arguments")
    fun wordBreak(
        s: String,
        wordDict: List<String>,
        expected: Boolean
    ) {
        assertEquals(
            expected,
            WordBreak139().wordBreak(s, wordDict)
        )
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("leetcode", listOf("leet", "code"), true),
                Arguments.of("applepenapple", listOf("apple", "pen"), true),
                Arguments.of("catsandog", listOf("cats", "dog", "sand", "and", "cat"), false),
                Arguments.of("a", listOf("b"), false),
                Arguments.of("cars", listOf("car", "ca", "rs"), true),
                Arguments.of("aaaaaaa", listOf("aaaa", "aa"), false),
                Arguments.of(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"),
                    false
                ),
            )
        }
    }
}