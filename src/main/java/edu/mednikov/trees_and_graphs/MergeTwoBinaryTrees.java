package edu.mednikov.trees_and_graphs;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">https://leetcode.com/problems/merge-two-binary-trees/</a>
 */
public class MergeTwoBinaryTrees {
    /**
     * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     *         1
     *  3           2
     * 5|null   null|null
     *
     *            2
     *      1            3
     *  null|4       null|7
     *
     *      3
     *  4        5
     * 5|4   null|7
     *
     * Output: [3,4,5,5,4,null,7]
     *
     *
     * */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeNodes(root1, root2);
    }

    private TreeNode mergeNodes(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        TreeNode l = mergeNodes(node1.left, node2.left);
        TreeNode r = mergeNodes(node1.right, node2.right);
        return new TreeNode(node1.val + node2.val, l, r);
    }

    public TreeNode mergeTreesIteratively(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
