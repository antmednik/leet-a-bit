package edu.mednikov.array_and_string;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        return solution02(nums);
    }

    private boolean solution01(int[] nums) {
        if (nums.length < 3) return false;

        // O (n^3)
        // time limit exceeded
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean solution02(int[] nums) {
        if (nums.length < 3) return false;

        // O(n) time & O(1) space?
        // https://medium.com/@xiaogegexiao/increasing-triplet-subsequence-problem-995471b338f1

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min1 = num;
            }

            if (num > min1) {
                min2 = Math.min(min2, num);
            }

            if (num > min2) {
                return true;
            }
        }

        return false;
    }
}
