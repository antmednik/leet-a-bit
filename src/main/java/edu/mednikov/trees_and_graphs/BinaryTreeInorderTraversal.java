package edu.mednikov.trees_and_graphs;


import java.util.*;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> nodes = new ArrayList<>();
//        recursiveInorderTraversal(root, nodes);
//        return nodes;

        return iterativeInorderTraversal(root);
    }

    private void recursiveInorderTraversal(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            recursiveInorderTraversal(node.left, nodes);
        }

        nodes.add(node.val);

        if (node.right != null) {
            recursiveInorderTraversal(node.right, nodes);
        }
    }

    private List<Integer> iterativeInorderTraversal(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();

        List<Integer> nodes = new ArrayList<>();
        TreeNode node = root;
        while (node != null || s.size() > 0) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }

            node = s.pop();
            nodes.add(node.val);

            node = node.right;
        }
        return nodes;
    }
}
