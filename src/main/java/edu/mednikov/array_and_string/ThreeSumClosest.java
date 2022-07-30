package edu.mednikov.array_and_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">...</a>
 */
public class ThreeSumClosest {
    /**
     * a + b + c = t
     * b + c = t - a = x
     * b + c = x
     *
     * */
    // Input: nums = [-1,2,1,-4], target = 1        [-4, -1, 1, 2] Output: 2
    public int threeSumClosest(int[] nums, int target) {
        return attempt3(nums, target);
    }

    int sillyAttempt(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int candidate = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(candidate - target);
        while (i < n - 2) {
            while (i < n - 3 && nums[i] == nums[i+1]) {
                i++;
            }
            int a = nums[i];
            int j = i + 1;
            while (j < n - 1) {
                while (j < n - 2 && nums[j] == nums[j+1]) {
                    j++;
                }
                int ab = a + nums[j];
                int k = j + 1;
                while (k < n) {
                    while (k < n-1 && nums[k] == nums[k+1]) {
                        k++;
                    }
                    int sum = ab + nums[k];
                    int diff = Math.abs(sum - target);
                    if (diff < delta) {
                        candidate = sum;
                        delta = diff;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return candidate;
    }

    int attempt1(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // -1
        int n = nums.length;
        int ia = 0, ic = n - 1;
        int[][] cases = new int[3][2];
        cases[0][0] = 0;
        cases[0][1] = 0;
        cases[1][0] = 0;
        cases[1][1] = -1;
        cases[2][0] = 1;
        cases[2][1] = 0;
        while (ia + 2 < ic) {
            while (ia < n - 4 && nums[ia] == nums[ia+1]) {
                ia++;
            }
            while (ic > 3 && nums[ic] == nums[ic-1]) {
                ic--;
            }
            for (int caseIdx = 0; caseIdx < 3; caseIdx++) {
                int localIa = ia + cases[caseIdx][0];   // 1
                int localIc = ic + cases[caseIdx][1];   // 3
                int a = nums[localIa];           // -1
                int c = nums[localIc];           // 2
                int ac = a + c;             // 1
                int targetB = target - ac;  // 1
                int candidateB = nums[localIa + 1];  // 1
                // a + b + c = t; b = t - (a + c)
                for (int ib = localIa + 2; ib < localIc; ib++) {
                    int b = nums[ib];
                    if (b == targetB) {  // 1
                        return target;
                    }
                    if (Math.abs(b - targetB) < Math.abs(candidateB - targetB)) {
                        candidateB = b;
                    }
                }
                int candidateSum = ac + candidateB; // 2
                if (Math.abs(target - candidateSum) < Math.abs(target - closestSum)) {
                    closestSum = candidateSum;
                }
            }
            ia++;
            ic--;
        }
        return closestSum;
    }

    int attempt2(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        // a + b + c = t;   b + c = t - a
        for (int ia = 0; ia < n-2; ia++) {
            int a = nums[ia];
            int ib = ia + 1, ic = n - 1;
            int targetBC = target - a;
            int closestBC = nums[ib] + nums[ic];
            int deltaBC = Math.abs(closestBC - targetBC);
            while (ib < ic) {
                int bc = nums[ib] + nums[ic];
                if (Math.abs(bc - targetBC) < deltaBC) {
                    closestBC = bc;
                    deltaBC = Math.abs(closestBC - targetBC);
                }
            }
            if (Math.abs(a + closestBC - target) < Math.abs(closestSum - target)) {
                closestSum = a + closestBC;
            }
        }
        return closestSum;
    }

    int attempt3(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n-2; i++) {
            int bc = find2Closest(nums, i+1, n-1, target - nums[i]);
            if (Math.abs(nums[i] + bc - target) < Math.abs(closestSum - target)) {
                closestSum = nums[i] + bc;
            }
        }
        return closestSum;
    }

    // b + c = x
    // b = x - c
    int find2Closest(int[] nums, int begin, int end, int x) {
        int i = begin, j = end;
        int closestSum = nums[i] + nums[j];
        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == x) return sum;

            if (Math.abs(sum - x) < Math.abs(closestSum - x)) {
                closestSum = sum;
            }

            if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        return closestSum;
    }
}
