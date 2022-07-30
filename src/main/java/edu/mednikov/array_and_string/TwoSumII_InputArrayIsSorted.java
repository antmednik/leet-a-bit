package edu.mednikov.array_and_string;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/</a>
 *
 * Constraints:
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> additionalToIdx = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer candidateIdx = additionalToIdx.get(numbers[i]);
            if (candidateIdx != null) {
                return new int[]{candidateIdx + 1, i + 1};
            }
            additionalToIdx.put(target - numbers[i], i);
        }
        throw new RuntimeException();
    }

    private int[] twoSumWithTwoPointers(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length -1;
        while (numbers[a] + numbers[b] != target) {
            if (numbers[a] + numbers[b] > target) {
                b--;
            } else {
                a++;
            }
        }
        return new int[]{a+1,b+1};
    }
}
