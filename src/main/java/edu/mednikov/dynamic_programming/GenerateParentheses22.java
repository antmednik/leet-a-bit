package edu.mednikov.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">descr</a>
 *
 * <a href="https://redquark.org/leetcode/0022-generate-parentheses/">solution</a>
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        return genParRoot(n);
    }

    private void genRec(String curr, int n, Set<String> cache) {
        if (curr.length() / 2 == n) return;

        cache.add("()" + curr);
        genRec("()" + curr, n, cache);

        cache.add("(" + curr + ")");
        genRec("(" + curr + ")", n, cache);

        cache.add(curr + "()");
        genRec(curr + "()", n, cache);
    }

    private List<String> genParRoot(int n) {
        // Resultant list
        List<String> result = new ArrayList<>();
        /// Recursively generate parentheses
        generateParenthesis(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generateParenthesis(List<String> result, StringBuilder s, int open, int close, int n) {
        // Base case
        if (open == n && close == n) {
            result.add(s.toString());
            return;
        }
        // If the number of open parentheses is less than the given n
        if (open < n) {
            generateParenthesis(result, s.append("("), open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }
        // If we need more close parentheses to balance
        if (close < open) {
            generateParenthesis(result, s.append(")"), open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
