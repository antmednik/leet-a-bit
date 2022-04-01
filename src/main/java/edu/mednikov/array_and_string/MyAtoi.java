package edu.mednikov.array_and_string;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it
 * remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than
 * 2^31 - 1 should be clamped to 2^31 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-2^31, 2^31 - 1], the final result is 42.
 *
 * Example 2:
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 *
 * Example 3:
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 * Constraints:
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class MyAtoi {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        boolean positive = true;
        if (s.charAt(i) == '-') {
            positive = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        StringBuilder digitsBuilder = new StringBuilder();
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            digitsBuilder.append(s.charAt(i));
            i++;
        }
        String digits = digitsBuilder.toString();
        // Integer.MAX_VALUE = 2 147 483 647
        // Integer.MIN_VALUE = -2 147 483 648
        if (digits.length() > 10 ||
                (digits.length() == 10 && digits.charAt(0) > '2')) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        int result = 0;
        int power = 1;
        for (int j = digits.length() - 1; j >= 0; j--) {
            int member = power * digit(digits.charAt(j));
            result += positive ? member : -1 * member;
            power *= 10;

            if (j > 0) {
                if (positive) {
                    if (result >= Integer.MAX_VALUE - power * digit(digits.charAt(j-1))) {
                        // result + power * digit(digits.charAt(j-1)) >= Integer.MAX_VALUE
                        return Integer.MAX_VALUE;
                    }
                } else {
                    // result - power * digit(digits.charAt(j-1)) <= Integer.MIN_VALUE
                    if (result <= Integer.MIN_VALUE + power * digit(digits.charAt(j-1))) {
                        // result + power * digit(digits.charAt(j-1)) >= Integer.MAX_VALUE
                        return Integer.MIN_VALUE;
                    }
                }

            }
        }
        return result;
    }

    private int digit(char digitAsChar) {
        return digitAsChar - '0';
    }
}
