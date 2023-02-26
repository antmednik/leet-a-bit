package edu.mednikov.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">descr</a>
 *
 * <a href="https://dev.to/seanpgallivan/solution-jump-game-ii-cn3">solution</a>
 */
public class JumpGameII45 {
    public int jump(int[] nums) {
        return jumpOptimal(nums);
    }

    private int jump01(int[] nums) {
        int n = nums.length;
        int[] jumpCount = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int limit = Math.min(i + nums[i], n - 1);
            for (int j = i+1; j <= limit; j++) {
                if (jumpCount[j] == 0) {
                    jumpCount[j] = jumpCount[i] + 1;
                } else {
                    jumpCount[j] = Math.min(jumpCount[i] + 1, jumpCount[j]);
                }
            }
        }
        return jumpCount[n-1];
    }

    private int jumpOptimal(int[] nums) {
        int len = nums.length - 1, curr = -1, next = 0, ans = 0;
        for (int i = 0; next < len; i++) {
            if (i > curr) {
                ans++;
                curr = next;
            };
            next = Math.max(next, nums[i] + i);
        };
        return ans;
    }
}
