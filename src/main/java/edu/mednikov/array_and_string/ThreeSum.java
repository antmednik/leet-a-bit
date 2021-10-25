package edu.mednikov.array_and_string;

import java.util.*;

public class ThreeSum {
    /*
    * 3Sum
    *
    * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
    *
    * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
    * and j != k, and nums[i] + nums[j] + nums[k] == 0.
    * Notice that the solution set must not contain duplicate triplets.
    *
    * Example 1:
    * Input: nums = [-1,0,1,2,-1,-4]
    * Output: [[-1,-1,2],[-1,0,1]]
    *
    * Example 2:
    * Input: nums = []
    * Output: []
    *
    * Example 3:
    * Input: nums = [0]
    * Output: []
    *
    * Constraints:
    * 0 <= nums.length <= 3000
    * -105 <= nums[i] <= 105
    *
    * Solution: https://fizzbuzzed.com/top-interview-questions-1/
    * */

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumWithTwoPointerTrick(nums);
    }


    public List<List<Integer>> threeSumWithHashMap(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            Set<Integer> passed = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (passed.contains(-nums[i] - nums[j])) {
                    result.add(List.of(nums[i], nums[j], -nums[i] - nums[j]));

                    while (j + 1 < n && nums[j+1] == nums[j]) ++j;
                }
                passed.add(nums[j]);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumWithTwoPointerTrick(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < n - 1 && nums[j-1] == nums[j]) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
