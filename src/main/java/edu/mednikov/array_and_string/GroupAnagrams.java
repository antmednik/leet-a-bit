package edu.mednikov.array_and_string;

import java.sql.Array;
import java.util.*;

/**
 * Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) new ArrayList();

        Map<String, List<String>> result = new HashMap<>();
        byte[] counts = new byte[26];
        for (final var str : strs) {
            Arrays.fill(counts, (byte)0);
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                key.append(counts[i]);
                key.append("_");
            }
            key.deleteCharAt(key.length() - 1);

            result.computeIfAbsent(key.toString(), $ -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
