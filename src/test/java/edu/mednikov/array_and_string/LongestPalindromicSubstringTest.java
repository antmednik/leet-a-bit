package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void longestPalindromeTest1() {
        assertThat(new LongestPalindromicSubstring().longestPalindrome("babad"))
                .isEqualTo("bab");
    }

    @Test
    void longestPalindromeTest2() {
        assertThat(new LongestPalindromicSubstring().longestPalindrome("cbbd"))
                .isEqualTo("bb");
    }
}