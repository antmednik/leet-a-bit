package edu.mednikov.binary_search;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">https://leetcode.com/problems/search-insert-position/</a>
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 */
public class SearchInsertPosition {


    /**
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     *
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     */
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if (val == target) {
                return mid;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return target > nums[lo] ? lo + 1 : lo;
    }
}
