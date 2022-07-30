package edu.mednikov.array_and_string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!duplicates.add(nums[i])) return true;
        }
        return false;
    }
}
