package edu.mednikov.array_and_string;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://www.geeksforgeeks.org/container-with-most-water/
 * */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        return maxArea1(height);
    }

    private int maxArea0(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxRightBorder = 1;
        for (int i = 1; i < height.length; i++) {
            if (height[i] * i > height[maxRightBorder] * maxRightBorder) {
                maxRightBorder = i;
            }
        }
        int maxLeftBorder = maxRightBorder - 1;
        for (int i = maxLeftBorder - 1; i > -1; i--) {
            if (Math.min(height[maxRightBorder], height[maxLeftBorder]) * (maxRightBorder - maxLeftBorder) <
                    Math.min(height[maxRightBorder], height[i]) * (maxRightBorder - i)) {
                maxLeftBorder = i;
            }
        }
        return Math.min(height[maxRightBorder], height[maxLeftBorder]) * (maxRightBorder - maxLeftBorder);
    }

    private int maxArea1(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        /*
        * a * c
        * b * (c - 1) = bc - b
        * bc - b > a*c => b > a * c / (c - 1) => b*(c - 1) > area
        * a + 1 > a * c / (c - 1) => (a+1)*(c-1) > ac => ac + c -a -1 > ac => c - a > 1 => a < c - 1
        * (a + n) * (c-1) > a * c => ac + nc - a - n > ac => n(c - 1) > a
        * */
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
