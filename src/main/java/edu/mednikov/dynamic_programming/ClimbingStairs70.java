package edu.mednikov.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">description</a>
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] r = new int[n + 1];
        r[1] = 1;
        r[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            r[i] = -1;
        }
        return csRec(n, r);
    }

    private int csRec(int n, int[] r) {
        if (r[n] != -1) return r[n];

        r[n - 1] = csRec(n - 1, r);
        r[n - 2] = csRec(n - 2, r);

        return r[n - 1] + r[n - 2];
    }
}
