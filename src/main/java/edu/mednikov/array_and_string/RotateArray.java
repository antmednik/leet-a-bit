package edu.mednikov.array_and_string;


/**
 * <a href="https://leetcode.com/problems/rotate-array/">https://leetcode.com/problems/rotate-array/</a>
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        rotateAlternative1(nums, k);
    }

    private void rotateWithCycles(int[] nums, int k) {
        int n = nums.length;
        int s = k % n;
        if (s == 0) return;

        int m = 0, i = 0, j, t1, t2;
        while (m < n) {
            j = (i + s) % n;
            t1 = nums[i];
            while (j != i) {
                t2 = nums[j];
                nums[j] = t1;
                t1 = t2;
                j = (j + s) % n;
                m++;
            }
            nums[i] = t1;
            m++;
            i++;
        }
    }

    private void rotateSTimesBy1(int[] nums, int k) {
        int s = k % nums.length;
        if (s == 0) return;

        for (int i = 0; i < s; i++) {
            rotate1(nums);
        }
    }

    private void rotate1(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }

    private void reverse(int[] nums, int start, int end) {
        for(int i=start, j=end; i<j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private void rotateAlternative1(int[] nums, int k) {
        int len = nums.length;
        if(k == 0)
            return ;
        if(k > len)
            k = k%len;
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-k-1);
        reverse(nums, 0, len-1);
    }
}
