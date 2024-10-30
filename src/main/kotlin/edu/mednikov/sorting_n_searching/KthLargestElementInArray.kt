package edu.mednikov.sorting_n_searching

/**
 * Kth Largest Element in an Array
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
class KthLargestElementInArray {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        if (k == nums.size) return nums.min()

        // QuickSelect with Lomuto's partition
        var left = 0
        var right = nums.size - 1
        var pivotIndex: Int
        do {
            pivotIndex = paritition(nums, left, right)
            if (pivotIndex == nums.size - k) return pivotIndex
            if (pivotIndex < nums.size - k) {
                right = pivotIndex
            } else {
                left = pivotIndex
            }
        } while (pivotIndex != nums.size - k)
        return nums[pivotIndex]
    }

    private fun paritition(nums: IntArray, left: Int, right: Int): Int {
        val pivotIndex: Int = (left + right) / 2
        nums.swap(pivotIndex, right)

        var storeIndex = left
        for (i in left..right) {
            if (nums[i] < nums[right]) {
                nums.swap(i, storeIndex)
                storeIndex++
            }
        }
        nums.swap(right, storeIndex)
        return pivotIndex
    }

    private fun IntArray.swap(i: Int, j: Int) {
        if (i != j) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }
    }
}