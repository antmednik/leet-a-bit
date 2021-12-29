package edu.mednikov.tree_and_graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    void zigzagLevelOrderTest01() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(7)));

        var actual = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        assertThat(actual.get(0)).containsExactly(1);
        assertThat(actual.get(1)).containsExactly(3, 2);
        assertThat(actual.get(2)).containsExactly(4, 5, 6, 7);
        assertThat(actual.get(3)).containsExactly(9, 8);
    }

    @Test
    void zigzagLevelOrderTest02() {
        TreeNode root = new TreeNode(1);

        var actual = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        assertThat(actual.get(0)).containsExactly(1);
    }

    @Test
    void zigzagLevelOrderTest03() {
        TreeNode root = null;

        var actual = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        assertThat(actual).isEmpty();
    }

    //[3,9,20,null,null,15,7]
    @Test
    void zigzagLevelOrderTest04() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        var actual = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        assertThat(actual.get(0)).containsExactly(3);
        assertThat(actual.get(1)).containsExactly(20, 9);
        assertThat(actual.get(2)).containsExactly(15, 7);
    }
}