package edu.mednikov.tree

import java.util.*


/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the
 * node's value. If it is a null node, we record using a sentinel value such as '#'.
 *
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#'
 * represents a null node.
 *
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization
 * of a binary tree.
 *
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#'
 * representing null pointer.
 *
 * You may assume that the input format is always valid.
 *
 * For example, it could never contain two consecutive commas, such as "1,,3".
 * Note: You are not allowed to reconstruct the tree.
 *
 * Example 1:
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 *
 *         9
 *   3          2
 * 4    1           6
 *
 * Output: true
 *
 * Example 2:
 * Input: preorder = "1,#"
 * Output: false
 *
 * Example 3:
 * Input: preorder = "9,#,#,1"
 * Output: false
 *
 * Constraints:
 * 1 <= preorder.length <= 104
 * preorder consist of integers in the range [0, 100] and '#' separated by commas ','.
 */
class VerifyPreorderSerializationOfBinaryTree331 {
    fun isValidSerialization(preorder: String): Boolean {
        return isValidSerialization0(preorder)
    }

    private fun isValidSerialization0(preorder: String): Boolean {
        return rec(preorder, 0) == preorder.length + 1
    }

    private fun rec(preorder: String, i: Int): Int {
        if (i >= preorder.length) return preorder.length + 2
        val isNull = preorder[i] == NULL_NODE
        var j = i
        while (j < preorder.length && preorder[j] != SEPARATOR) {
            j++
        }
        j++
        if (isNull) return j

        // left
        val afterLeftIndex = rec(preorder, j)

        // right
        return rec(preorder, afterLeftIndex)
    }

    /**
     * slots solution
     *
     * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/solutions/3889424/kotlin-slots-solution
     *
     * Intuition
     * We can think of the tree's structure as a series of "slots" where nodes can be placed. Initially, there's one
     * slot for the root. Every non-null node fills one slot and creates two new slots for its children. A null node
     * simply fills one slot without creating new ones.
     *
     * Approach
     * Initialize Slots: Start with one available slot for the root node.
     * Process Nodes: Iterate through the nodes in the preorder string.
     * Non-Null Node: If the node is not null, one slot is filled, and one new slot is created for the left child.
     * Null Node: If the node is null, one slot is filled, and no new slots are created.
     * Check Slots: If there are no available slots at the end, the serialization is correct.
     *
     * Complexity
     * Time complexity:
     * O(n)
     *
     * Space complexity:
     * O(1)
     */

    private fun isValidSerializationWithSlots(preorder: String): Boolean {
        val nodes = preorder.split(",")
        var slots = 1 // Start with one available slot for the root node

        for (node in nodes) {
            // One slot is filled by the current node
            slots--

            // If no slots are available, the serialization is incorrect
            if (slots < 0) return false

            // If the node is not null, one new slot is created for the left child
            if (node != "#") slots += 2
        }

        // If there are no available slots at the end, the serialization is correct
        return slots == 0
    }

    // stack solution
    private fun isValidSerializationWithStack(preorder: String): Boolean {
        if (preorder[0] == '#') {
            return preorder.length == 1
        }

        val input = preorder.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val stack = Stack<Int>()

        for (i in input.indices) {
            if (input[i] != "#") {
                stack.push(2)
            } else {
                stack.push(stack.pop() - 1)
                while (stack.peek() == 0) {
                    stack.pop()
                    if (stack.isEmpty()) {
                        return if (i == input.size - 1) true
                        else false
                    } else {
                        stack.push(stack.pop() - 1)
                    }
                }
            }
        }
        return stack.isEmpty()
    }

    companion object {
        const val NULL_NODE = '#'
        const val SEPARATOR = ','
    }
}