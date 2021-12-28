package edu.mednikov.tree_and_graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeInorderTraversalTest {

    @Test
    void inorderTraversal01() {

        BinaryTreeInorderTraversal.TreeNode root = new BinaryTreeInorderTraversal.TreeNode(1,
                null,
                new BinaryTreeInorderTraversal.TreeNode(2,
                        new BinaryTreeInorderTraversal.TreeNode(3),
                        null));

        var actual = new BinaryTreeInorderTraversal().inorderTraversal(root);

        assertThat(actual).containsExactly(1, 3, 2);
    }
}