package edu.mednikov.tree_and_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        traverse(root, 1, nodes);
        zigZag(nodes);
        return nodes;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> nodes) {
        if (level > nodes.size()) {
            nodes.add(new ArrayList<>());
        }
        nodes.get(level - 1).add(node.val);

        if (node.left != null) {
            traverse(node.left, level + 1, nodes);
        }

        if (node.right != null) {
            traverse(node.right, level + 1, nodes);
        }
    }

    private void zigZag(List<List<Integer>> nodes) {
        for (int i = 1; i < nodes.size(); i += 2) {
            reverse(nodes.get(i));
        }
    }

    private void reverse(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int j = list.size() - 1 - i;

            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }

}
