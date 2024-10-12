package edu.mednikov.generation

/**
 * https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/
 *
 * You are given a positive integer n.
 *
 * A binary string x is valid if all
 * substrings
 *  of x of length 2 contain at least one "1".
 *
 * Return all valid strings with length n, in any order.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["010","011","101","110","111"]
 * Explanation:
 * The valid strings of length 3 are: "010", "011", "101", "110", and "111".
 *
 * Example 2:
 * Input: n = 1
 * Output: ["0","1"]
 * Explanation:
 * The valid strings of length 1 are: "0" and "1".
 *
 * Constraints:
 * 1 <= n <= 18
 */
class GenerateBinaryStringsWithoutAdjacentZeros3211 {
    fun validStrings(n: Int): List<String> {
        if (n == 1) return listOf("0", "1")
        if (n == 2) return listOf("01", "10", "11")

        val result = mutableListOf<String>()
        val state = CharArray(n)
        state[0] = '0'
        generateRec(state, 0, n, result)
        state[0] = '1'
        generateRec(state, 0, n, result)
        return result
    }

    private fun generateRec(state: CharArray, i: Int, n: Int, result: MutableList<String>) {
        if (i == n - 1) {
            result.add(String(state))
            return
        }

        val j = i + 1
        if (state[i] == '0') {
            state[j] = '1'
            generateRec(state, j, n, result)
        } else {
            state[j] = '0'
            generateRec(state, j, n, result)
            state[j] = '1'
            generateRec(state, j, n, result)
        }
    }
}