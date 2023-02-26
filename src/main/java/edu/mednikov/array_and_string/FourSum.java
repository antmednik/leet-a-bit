package edu.mednikov.array_and_string;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/4sum/">...</a>
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return attempt1(nums, target);
    }

    private List<List<Integer>> attempt1(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int k = j + 1, l = n-1;
                long ab = nums[i] + nums[j];
                while (k < l) {
                    long sum = ab + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[k] ,nums[l]));
                    }
                    if (sum <= target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result.stream().map(r -> r.stream().toList()).toList();
    }
}
