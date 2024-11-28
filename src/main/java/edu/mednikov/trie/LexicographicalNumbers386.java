package edu.mednikov.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 *
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
 *
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
 * Example 2:
 *
 * Input: n = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 5 * 10^4
 */
public class LexicographicalNumbers386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        lexicalOrderGenerator(n, result, new StringBuilder());
        return result;
    }

    private void lexicalOrderGenerator(int n, List<Integer> result, StringBuilder currentValue) {
        for (int i = currentValue.isEmpty() ? 1 : 0; i < 10; i++) {
            currentValue.append(DIGITS[i]);
            int value = Integer.parseInt(currentValue.toString());
            if (value <= n) {
                result.add(value);
                lexicalOrderGenerator(n, result, currentValue);
            }
            currentValue.deleteCharAt(currentValue.length() - 1);
        }
    }

    private static final char[] DIGITS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


    /**
     * Solution without string operations
     */
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next > n) {
                break;
            }
            dfs(next, n, result);
        }
    }
}
