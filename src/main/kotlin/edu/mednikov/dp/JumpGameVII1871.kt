package edu.mednikov.dp

import kotlin.math.max
import kotlin.math.min

/**
 * 1871. Jump Game VII
 *
 * https://leetcode.com/problems/jump-game-vii/description/
 *
 * You are given a 0-indexed binary string s and two integers minJump and maxJump.
 * In the beginning, you are standing at index 0, which is equal to '0'.
 * You can move from index i to index j if the following conditions are fulfilled:
 *
 * i + minJump <= j <= min(i + maxJump, s.length - 1), and
 * s[j] == '0'.
 * Return true if you can reach index s.length - 1 in s, or false otherwise.
 *
 * Example 1:
 * Input: s = "011010", minJump = 2, maxJump = 3
 * Output: true
 * Explanation:
 * In the first step, move from index 0 to index 3.
 * In the second step, move from index 3 to index 5.
 *
 * Example 2:
 * Input: s = "01101110", minJump = 2, maxJump = 3
 * Output: false
 *
 * Constraints:
 * 2 <= s.length <= 10^5
 * s[i] is either '0' or '1'.
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 */
class JumpGameVII1871 {
    /**
     * Solution explanation:
     * https://github.com/doocs/leetcode/blob/main/solution/1800-1899/1871.Jump%20Game%20VII/README_EN.md
     *
     * 011101110101110111
     *
     * 0111111x........x
     *        x........x
     *         x........x
     *          x........x
     *           x........x
     *            x........x
     *             x........x
     *                 x........x
     *
     *
     * x_________x_x___________x____x___________x____x
     * x_____xxx_____x_x_______x
     */
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        return canReach2(s, minJump, maxJump)
    }

    private fun canReach0(s: String, minJump: Int, maxJump: Int): Boolean {
        val reachable = BooleanArray(s.length)
        reachable[0] = true
        var i = 0
        while (i < s.length) {
            if (!reachable[i]) {
                i++
                continue
            }
            var j = i + minJump
            while (j <= min(i + maxJump, s.length - 1)) {
                if (s[j] == '0') {
                    reachable[j] = true
                }
                j++
            }
            i++
        }
        return reachable[s.length - 1]
    }

    private fun canReach1(s: String, minJump: Int, maxJump: Int): Boolean {
        val reachable = BooleanArray(s.length)
        reachable[0] = true

        var lastCoveredEnd = 0
        var i = 0
        while (i < s.length) {
            if (!reachable[i]) {
                i++
                continue
            }
            var j = max(i + minJump, lastCoveredEnd)
            while (j <= min(i + maxJump, s.length - 1)) {
                if (s[j] == '0') {
                    reachable[j] = true
                    lastCoveredEnd = j
                }
                j++
            }
            i++
        }
        return reachable[s.length - 1]
    }

    /**
     * from [https://github.com/doocs/leetcode/blob/main/solution/1800-1899/1871.Jump%20Game%20VII/README_EN.md]
     *
     * We define a prefix sum array $pre$ of length $n+1$, where $pre[i]$ represents the number of reachable positions
     * in the first $i$ positions of $s$. We define a boolean array $f$ of length $n$, where $f[i]$ indicates whether
     * $s[i]$ is reachable. Initially, $pre[1] = 1$ and $f[0] = true$.
     *
     * Consider $i \in [1, n)$, if $s[i] = 0$, then we need to determine whether there exists a position $j$ in the
     * first $i$ positions of $s$, such that $j$ is reachable and the distance from $j$ to $i$ is within
     * $[minJump, maxJump]$. If such a position $j$ exists, then we have $f[i] = true$, otherwise $f[i] = false$.
     * When determining whether $j$ exists, we can use the prefix sum array $pre$ to determine whether such
     * a position $j$ exists in $O(1)$ time.
     *
     * "011010", 2, 3 => true
     *  "01101110", 2, 3 => false
     */
    private fun canReach2(s: String, minJump: Int, maxJump: Int): Boolean {
        val n = s.length
        val pre = IntArray(n + 1)
        pre[1] = 1
        val f = BooleanArray(n)
        f[0] = true
        for (i in 1 until n) {
            if (s[i] == '0') {
                /**
                 * "Mirroring" state is considered - instead of considering index i and set of reachable indexes from i
                 * - [i + minJump; i + maxJump], we consider index i and set of indexes from which i is reachable -
                 * [i - maxJump; i - minJump].
                 *
                 * pre[r + 1] > pre[l] means that there are at least one reachable index in [l - 1; r] range.
                 */
                val l = max(0, i - maxJump)
                val r = i - minJump
                f[i] = l <= r && pre[r + 1] - pre[l] > 0
            }
            pre[i + 1] = pre[i] + (if (f[i]) 1 else 0)
        }
        return f[n - 1]
    }
}