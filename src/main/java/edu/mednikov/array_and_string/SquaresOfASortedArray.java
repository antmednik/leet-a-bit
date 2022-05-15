package edu.mednikov.array_and_string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">https://leetcode.com/problems/squares-of-a-sorted-array/</a>
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            return new int[] {nums[0] * nums[0]};
        }

        /*
        * cases:
        * 1 - all positives
        * 2 - all negatives
        * 3 - mixed
        * */

        int[] result = new int[nums.length];

        // all positives
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }

        // all negatives
        if (nums[nums.length - 1] <= 0) {
            for (int i = 0; i < nums.length; i++) {
                result[nums.length - 1 - i] = nums[i] * nums[i];
            }
            return result;
        }

        // mixed
        int zeroPos = Arrays.binarySearch(nums, 0);
        int i = 0, l, r;
        if (zeroPos < 0) {
            zeroPos = -(zeroPos + 1);
            l = zeroPos - 1;
            r = zeroPos;
        } else {
            l = zeroPos - 1;
            r = zeroPos + 1;
            result[i++] = 0;
        }
        while (0 <= l && r <= nums.length - 1) {
            if (Math.abs(nums[l]) <= Math.abs(nums[r])) {
                result[i++] = nums[l] * nums[l];
                l--;
            } else {
                result[i++] = nums[r] * nums[r];
                r++;
            }
        }
        while (0 <= l) {
            result[i++] = nums[l] * nums[l];
            l--;
        }
        while (r <= nums.length - 1) {
            result[i++] = nums[r] * nums[r];
            r++;
        }
        return result;
    }
}
