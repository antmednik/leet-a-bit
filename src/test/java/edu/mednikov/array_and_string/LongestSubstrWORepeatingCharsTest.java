package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstrWORepeatingCharsTest {

    @Test
    public void test1() {
        assertThat(new LongestSubstrWORepeatingChars().lengthOfLongestSubstring("abcabcbb"))
                .isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(new LongestSubstrWORepeatingChars().lengthOfLongestSubstring("bbbbb"))
                .isEqualTo(1);
    }

    @Test
    public void test3() {
        assertThat(new LongestSubstrWORepeatingChars().lengthOfLongestSubstring("pwwkew"))
                .isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(new LongestSubstrWORepeatingChars().lengthOfLongestSubstring(""))
                .isEqualTo(0);
    }
}
