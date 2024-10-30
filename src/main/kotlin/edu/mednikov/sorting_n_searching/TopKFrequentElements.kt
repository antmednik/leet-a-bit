package edu.mednikov.sorting_n_searching

import java.util.PriorityQueue

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
 *
 * Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums) {
            map.compute(i) { _, v -> if (v == null) 1 else v + 1}
        }

        val result = IntArray(k)
        val pq = PriorityQueue(PairComparator())
        for (pair in map.entries) {
            pq.offer(pair)
        }
        for (j in 0..k-1) {
            result[j] = pq.remove().key
        }
        return result
    }

    class PairComparator : Comparator<MutableMap.MutableEntry<Int, Int>> {
        override fun compare(o1: MutableMap.MutableEntry<Int, Int>, o2: MutableMap.MutableEntry<Int, Int>): Int {
            return o2.value.compareTo(o1.value)
        }
    }
}