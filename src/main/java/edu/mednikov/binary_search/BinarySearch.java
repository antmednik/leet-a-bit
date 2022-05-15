package edu.mednikov.binary_search;

/**
 * <a href="https://leetcode.com/problems/binary-search/">https://leetcode.com/problems/binary-search/</a>
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 * Notes:
 * 1. For preventing overflow use
 * mid = low + (high - low) / 2
 * instead of
 * mid = (low + high) / 2
 * 2.
 */
public class BinarySearch {
    /**
     * case 1 - Input: nums = [-1,0,3,5,9,12], target = 9
     * low = 0 high = 5     mid = 2 candidate = 3
     * low = 3 high = 5     mid = 4 candidate = 9   return 4
     *
     * case 2 - Input: nums = [-1,0,3,5,9,12], target = 2
     * low = 0 high = 5     mid = 2 candidate = 3
     * low = 0 high = 1     mid = 0 candidate = -1
     * low = 1 high = 1     exit cycle      return -1
     */
    public int search(int[] nums, int target) {;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int candidate = nums[mid];
            if (candidate == target) {
                return mid;
            } else if (candidate < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
