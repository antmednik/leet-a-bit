package edu.mednikov.dynamic_programming;

/**
 * https://leetcode.com/problems/jump-game/description/
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element
 * in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
        return canJump0(nums);
    }

    /**
     * Idea: the current item can be reached if it can be reached from the previous or from an item before previous
     * considering that there was a hop spent to reach an item before previous.
     */
    private boolean canJump0(int[] nums) {
        if (nums.length == 1) return true;

        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = nums[i-1] == 0 ? 0 : Math.max(nums[i], nums[i-1] - 1);
        }
        return nums[nums.length - 2] > 0;
    }

    /**
     * Alternative solution idea (w/o array modification):
     * go from right to left and track the left most position that can be achieved from the current position.
     * After processing whole array, if the left most position == 0 then we can reach the last item.
     * */
}
