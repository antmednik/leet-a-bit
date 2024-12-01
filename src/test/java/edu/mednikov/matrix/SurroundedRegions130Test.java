package edu.mednikov.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegions130Test {

    @Test
    void test1() {
        char[][] board = {{'X'}};
        new SurroundedRegions130().solve(board);
        assertMatrixEquals(new char[][]{{'X'}}, board);

        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        new SurroundedRegions130().solve(board2);
        assertMatrixEquals(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
        }, board2);

        char[][] board3 = {
                {'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O'},
        };
        new SurroundedRegions130().solve(board3);
        assertMatrixEquals(new char[][]{
                {'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O'},
        }, board3);
    }

    private void assertMatrixEquals(char[][] expected, char[][] actual) {
        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

}