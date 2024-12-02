package edu.mednikov.array_and_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        return subarraySum1(nums, k);
    }

    private int subarraySum0(int[] nums, int k) {
        var candidates = new HashMap<Integer, List<Integer>>();

        // calculate prefix sum
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            var sum = nums[i];
            if (sum == k) {
                count++;
            }
            var cs = candidates.get(sum - k);
            if (cs != null) {
                count += cs.size();
            }
            candidates.computeIfAbsent(sum, k1 -> new ArrayList<>()).add(i);
        }
        return count;
    }

    /**
     * memory optimisation - no need to calculate prefix sum and store list of prev indexes (onlycount of indexes)
     */
    private int subarraySum1(int[] nums, int k) {
        var candidatesCount = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        candidatesCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            var cc = candidatesCount.get(sum - k);
            if (cc != null) {
                count += cc;
            }
            candidatesCount.put(sum, candidatesCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
