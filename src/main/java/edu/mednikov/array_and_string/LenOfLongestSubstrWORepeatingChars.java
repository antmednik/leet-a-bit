package edu.mednikov.array_and_string;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">https://leetcode.com/problems/longest-substring-without-repeating-characters/</a>
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LenOfLongestSubstrWORepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> indexes = new HashMap<>();
        int answer = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);

            Integer knownIndex = indexes.get(c);
            if (knownIndex != null) {
                i = Math.max(i, knownIndex);
                answer = Math.max(answer, j - i + 1);
            }

            indexes.put(c, j + 1);
        }
        return answer;
    }
}
