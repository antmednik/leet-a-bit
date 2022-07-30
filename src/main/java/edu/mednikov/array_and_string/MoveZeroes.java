package edu.mednikov.array_and_string;

/**
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n==1) return;
        // 0 1 0 3 12
        int i = 0, j = 1, tmp;
        while (i<n-1) {
            while (i < n-1 && nums[i] != 0) {
                i++;
            }
            if (i == n-1) return;
            j = i + 1;
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j == n) return;
            tmp = nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
}
