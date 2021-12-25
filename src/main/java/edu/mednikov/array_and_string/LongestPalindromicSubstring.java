package edu.mednikov.array_and_string;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

         int i = 0, i1, i2, pstart = 0, pend = 0;
         while (i < s.length()) {
             i1 = i2 = i;
             while (biggerPalindromeExists(s, i1, i2)) {
                 i1--;
                 i2++;
             }
             if (i2 - i1 > pend - pstart) {
                 pstart = i1;
                 pend = i2;
             }

             if (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                 i1 = i;
                 i2 = i + 1;
                 while (biggerPalindromeExists(s, i1, i2)) {
                     i1--;
                     i2++;
                 }
                 if (i2 - i1 > pend - pstart) {
                     pstart = i1;
                     pend = i2;
                 }
             }
             i++;
         }
         return s.substring(pstart, pend + 1);
    }

    private boolean biggerPalindromeExists(String s, int pstart, int pend) {
        if (pstart == 0 || pend == s.length() - 1) {
            return false;
        }
        return s.charAt(pstart - 1) == s.charAt(pend + 1);
    }
}
