package edu.mednikov.array_and_string;

/**
 * https://leetcode.com/problems/missing-number/
 *
 * Idea
 * Sum(1, 2, ..., n) = n * (n+1) / 2
 * x = sum - realSum
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int realSum = 0;
        int expectedSum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            realSum += nums[i];
        }
        return expectedSum - realSum;
    }
}
