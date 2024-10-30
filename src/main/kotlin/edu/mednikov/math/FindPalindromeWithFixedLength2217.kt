package edu.mednikov.math

import kotlin.math.pow

/**
 *
 * https://leetcode.com/problems/find-palindrome-with-fixed-length/description/
 *
 * Given an integer array queries and a positive integer intLength, return an array answer where answer[i] is
 * either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
 *
 * A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
 *
 * Example 1:
 * Input: queries = [1,2,3,4,5,90], intLength = 3
 * Output: [101,111,121,131,141,999]
 * Explanation:
 * The first few palindromes of length 3 are:
 * 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
 * The 90th palindrome of length 3 is 999.
 *
 * Example 2:
 * Input: queries = [2,4,6], intLength = 4
 * Output: [1111,1331,1551]
 * Explanation:
 * The first six palindromes of length 4 are:
 * 1001, 1111, 1221, 1331, 1441, and 1551.
 *
 *
 * Constraints:
 * 1 <= queries.length <= 5 * 10^4
 * 1 <= queries[i] <= 10^9
 * 1 <= intLength <= 15
 *
 */
class FindPalindromeWithFixedLength2217 {
    fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
        var maxQuery = 0
        val queriesMap = mutableMapOf<Int, Long>()
        val palindromesCount = palindromesCount(intLength)
        queries.forEach {
            if (it <= palindromesCount) {
                if (it > maxQuery) {
                    maxQuery = it
                }
                queriesMap.putIfAbsent(it, 0)
            }
        }
        if (intLength % 2 == 1)
            oddPalindromeGenerator(intLength, maxQuery, queriesMap)
        else
            evenPalindromeGenerator(intLength, maxQuery, queriesMap)
        val result = LongArray(queries.size)
        queries.forEachIndexed { index, _ ->
            result[index] = queriesMap.getOrDefault(queries[index], -1)
        }
        return result
    }

    private fun palindromesCount(intLength: Int): Long {
        if (intLength == 1) return 9

        var count = tenPower(intLength / 2 - 1) * 9
        if (intLength % 2 == 1) {
            count *= 10
        }
        return count
    }

    private fun evenPalindromeGenerator(intLength: Int, maxQuery: Int, queriesMap: MutableMap<Int, Long>) {
        val base = tenPower(intLength / 2 - 1)
        var currentBase = base
        for (i in 1..maxQuery) {
            if (queriesMap.containsKey(i)) {
                queriesMap[i] = preparePalindrome(base, currentBase)
            }
            currentBase++
        }
    }

    private fun preparePalindrome(base: Long, currentBase: Long): Long {
        var palindrome: Long = currentBase * base * 10L
        var mBase = base
        var mCurrentBase = currentBase
        while (mCurrentBase > 0) {
            val r = mCurrentBase % 10
            palindrome += r * mBase
            mBase /= 10
            mCurrentBase /= 10
        }
        return palindrome
    }

    private fun oddPalindromeGenerator(intLength: Int, maxQuery: Int, queriesMap: MutableMap<Int, Long>) {
        val base = tenPower(intLength / 2 - 1)
        var currentBase = base
        var oddDigit = if (intLength == 1) 1 else 0
        for (i in 1..maxQuery) {
            if (queriesMap.containsKey(i)) {
                queriesMap[i] = prepareOddPalindrome(intLength, base, currentBase, oddDigit)
            }
            oddDigit = (oddDigit + 1) % 10
            if (oddDigit == 0)
                currentBase++
        }
    }

    private fun prepareOddPalindrome(intLength: Int, base: Long, currentBase: Long, oddDigit: Int): Long {
        if (intLength == 1) return oddDigit.toLong()

        var palindrome: Long = currentBase * base * 100L
        palindrome += oddDigit * base * 10
        var mBase = base
        var mCurrentBase = currentBase
        while (mCurrentBase > 0) {
            val r = mCurrentBase % 10
            palindrome += r * mBase
            mBase /= 10
            mCurrentBase /= 10
        }
        return palindrome
    }

    private fun tenPower(x: Int): Long {
        var result = 1L
        repeat(x) {
            result *= 10
        }
        return result
    }
}