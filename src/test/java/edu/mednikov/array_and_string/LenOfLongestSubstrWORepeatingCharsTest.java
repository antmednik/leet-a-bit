package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LenOfLongestSubstrWORepeatingCharsTest {

    @Test
    public void test1() {
        assertThat(new LenOfLongestSubstrWORepeatingChars().lengthOfLongestSubstring("abcabcbb"))
                .isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(new LenOfLongestSubstrWORepeatingChars().lengthOfLongestSubstring("bbbbb"))
                .isEqualTo(1);
    }

    @Test
    public void test3() {
        assertThat(new LenOfLongestSubstrWORepeatingChars().lengthOfLongestSubstring("pwwkew"))
                .isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(new LenOfLongestSubstrWORepeatingChars().lengthOfLongestSubstring(""))
                .isEqualTo(0);
    }
}
