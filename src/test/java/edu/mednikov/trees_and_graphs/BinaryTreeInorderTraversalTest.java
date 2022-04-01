package edu.mednikov.trees_and_graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeInorderTraversalTest {

    @Test
    void inorderTraversal01() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),
                        null));

        var actual = new BinaryTreeInorderTraversal().inorderTraversal(root);

        assertThat(actual).containsExactly(1, 3, 2);
    }

    @Test
    void inorderTraversal02() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(7)));

        var actual = new BinaryTreeInorderTraversal().inorderTraversal(root);

        assertThat(actual).containsExactly(4, 2, 5, 1, 8, 6, 9, 3, 7);
    }
}