package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SetMatrixZeroesTest {

    @Test
    public void test1() {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}});
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}});
    }


    @Test
    public void test3() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {1, 2, 3, 4, 5}});
    }

    @Test
    public void test4() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 0, 5}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {0,0,0,0,0}});
    }

    @Test
    public void test5() {
        int[][] matrix = new int[][]{
                {1}, {2}, {3}, {4}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {1}, {2}, {3}, {4}});
    }

    @Test
    public void test6() {
        int[][] matrix = new int[][]{
                {1}, {2}, {3}, {4}, {0}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {0}, {0}, {0}, {0}, {0}});
    }

    @Test
    public void test7() {
        int[][] matrix = new int[][]{
                {0, 2, 3, 4, 5},
                {10, 11, 12, 13, 14},
                {20, 21, 21, 23, 24}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 11, 12, 13, 14},
                {0, 21, 21, 23, 24}});
    }

    @Test
    public void test8() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {10, 11, 12, 13, 14},
                {20, 21, 21, 0, 24}};
        new SetMatrixZeroes().setZeroes(matrix);
        assertThat(matrix).isDeepEqualTo(new int[][]{
                {1, 2, 3, 0, 5},
                {10, 11, 12, 0, 14},
                {0, 0, 0, 0, 0}});
    }
}
