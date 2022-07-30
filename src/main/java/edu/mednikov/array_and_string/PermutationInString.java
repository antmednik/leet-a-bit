package edu.mednikov.array_and_string;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">https://leetcode.com/problems/permutation-in-string/</a>
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        Map<Character, Short> delta = buildInitialDelta(s1, s2);
        if (delta.isEmpty()) {
            return true;
        }

        int start = 0, end = s1.length() - 1;
        while (end < s2.length() - 1) {
            updateDelta(delta, s2.charAt(start), s2.charAt(end + 1));
            if (delta.size() == 0) return true;

            start++;
            end++;
        }
        return false;
    }

    private Map<Character, Short> buildInitialDelta(String s1, String s2) {
        Map<Character, Short> delta = buildStats(s2, 0, s1.length() - 1);
        for (int i = 0; i < s1.length(); i++) {
            subtractFromDelta(delta, s1.charAt(i));
        }
        return delta;
    }

    private Map<Character, Short> buildStats(String s, int start, int end) {
        Map<Character, Short> stats = new HashMap<>();
        for (int i = start; i <= end; i++) {
            stats.merge(s.charAt(i), (short)1, (a, b) -> (short) (a + b));
        }
        return stats;
    }

    private void updateDelta(Map<Character, Short> delta, char oldC, char newC) {
        subtractFromDelta(delta, oldC);
        addToDelta(delta, newC);
    }

    private void addToDelta(Map<Character, Short> delta, char c) {
        updateDelta(delta, c, (short)1, (short)-1, (short)1);
    }

    private void subtractFromDelta(Map<Character, Short> delta, char c) {
        updateDelta(delta, c, (short)-1, (short)1, (short)-1);
    }

    private void updateDelta(Map<Character, Short> delta, char c, short initialValue,
                             short valueOnRemove, short step) {
        Short count = delta.get(c);
        if (count == null) {
            delta.put(c, initialValue);
        } else {
            if (count == valueOnRemove) {
                delta.remove(c);
            } else {
                delta.put(c, (short)(count + step));
            }
        }
    }

}
