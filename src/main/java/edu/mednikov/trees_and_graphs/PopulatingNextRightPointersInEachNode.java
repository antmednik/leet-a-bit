package edu.mednikov.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">leet code</a>
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to
 * point to its next right node, just like in Figure B. The serialized output is in level order as connected by
 * the next pointers, with '#' signifying the end of each level.
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 *
 * Follow-up:
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        //recursiveWithExtraSpace(root);
        iterativeWithoutExtraSpace(root);
        return root;
    }

    private void iterativeWithoutExtraSpace(Node root) {
        if (root == null) return;

        Node current = root;
        while (current.left != null) {
            Node nextLevel = current.left;
            while (current != null) {
                current.left.next = current.right;
                if (current.next == null) {
                    current.right.next = null;
                } else {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            current = nextLevel;
        }
    }

    private void recursiveWithExtraSpace(Node root) {
        if (root == null) {
            return;
        }
        List<Node> leftNeighbours = new ArrayList<>();
        recursiveWithExtraSpace0(root, 0, leftNeighbours);
    }

    private void recursiveWithExtraSpace0(Node node, int level, List<Node> leftNeighbours) {

        if (leftNeighbours.size() == level) {
            leftNeighbours.add(node);
        } else {
            leftNeighbours.get(level).next = node;
            leftNeighbours.set(level, node);
        }

        if (node.left != null) {
            recursiveWithExtraSpace0(node.left, level + 1, leftNeighbours);
        }

        if (node.right != null) {
            recursiveWithExtraSpace0(node.right, level + 1, leftNeighbours);
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
