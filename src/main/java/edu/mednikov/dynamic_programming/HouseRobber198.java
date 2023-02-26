package edu.mednikov.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/house-robber/">Description</a>
 *
 * Solution description:
 *  https://medium.com/outco/how-to-solve-the-house-robber-problem-f3535ebaef1b
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        return attempt2(nums);
    }

    private int attempt1(int[] nums) {  // 2 7 9 3 1
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] amount = new int[n];
        amount[0] = nums[0];
        amount[1] = nums[1];
        int[] prevAmount = new int[n];
        int maxAmount = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int localMaxAmount = 0;
            for (int j = 0; j < i - 1; j++) {
                if (localMaxAmount < amount[j]) {
                    localMaxAmount = amount[j];
                }
            }
            amount[i] = localMaxAmount + nums[i];      // 2 7 11 10 12
            if (maxAmount < amount[i]) {
                maxAmount = amount[i];
            }
        }
        return maxAmount;
    }

    int attempt2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] amount = new int[n];
        amount[0] = nums[0];
        amount[1] = Math.max(amount[0], nums[1]);
        for (int i = 2; i < n; i++) {
            amount[i] = Math.max(nums[i] + amount[i-2], amount[i - 1]);
        }
        return amount[n-1];
    }
}
