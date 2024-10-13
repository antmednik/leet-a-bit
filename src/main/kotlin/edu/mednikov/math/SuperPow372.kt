package edu.mednikov.math

/**
 * [372. Super Pow](https://leetcode.com/problems/super-pow/description/)
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 *
 * Example 1:
 * Input: a = 2, b = [3]
 * Output: 8
 *
 * Example 2:
 * Input: a = 2, b = [1,0]
 * Output: 1024
 *
 * Example 3:
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 *
 * Constraints:
 * 1 <= a <= 2^31 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b does not contain leading zeros.
 */
class SuperPow372 {

    fun superPow(a: Int, b: IntArray): Int {
        return superPow0(a, b)
    }

    /**
     * Solution from
     * https://authorslog.com/blog/dSHL4GVkXI?title=372.-super-pow
     */
    private fun pow(a: Int, b: Int): Int {
        var a = a
        var result = 1
        a %= MOD // Taking mod to prevent overflow
        for (i in 0 until b) {
            result = (result * a) % MOD
        }
        return result
    }

    private fun superPow0(a: Int, b: IntArray): Int {
        var a = a
        var result = 1
        for (i in b.indices.reversed()) {
            result = (result * pow(a, b[i])) % MOD
            a = pow(a, 10) // Power up for the next iteration
        }
        return result
    }

    companion object {
        private const val MOD = 1337
    }
}