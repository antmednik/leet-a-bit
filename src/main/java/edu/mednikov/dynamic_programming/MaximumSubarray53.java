package edu.mednikov.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/submissions/">description</a>
 *
 * <a href="https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/">Kadane's algorithm</a>
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        return solution1(nums);
    }

    int solveViaPrefixes(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int maxLeftPrefix = nums[0], maxLeftPrefixIdx = 0, currLeftPrefixSum = nums[0],
                maxRightPrefix = nums[n - 1], maxRightPrefixIdx = n - 1, currRightPrefixSum = nums[n - 1];
        for (int i = 1; i < n; i++) {
            currLeftPrefixSum += nums[i];
            if (currLeftPrefixSum > maxLeftPrefix) {
                maxLeftPrefix = currLeftPrefixSum;
                maxLeftPrefixIdx = i;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            currRightPrefixSum += nums[i];
            if (currRightPrefixSum > maxRightPrefix) {
                maxRightPrefix = currRightPrefixSum;
                maxRightPrefixIdx = i;
            }
        }
        int sum = 0;
        for (int i = maxRightPrefixIdx; i <= maxLeftPrefixIdx; i++) {
            sum += nums[i];
        }
        return sum;
    }

    int solution1(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
