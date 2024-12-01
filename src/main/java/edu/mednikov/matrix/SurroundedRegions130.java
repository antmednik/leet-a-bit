package edu.mednikov.matrix;

public class SurroundedRegions130 {
    public void solve(char[][] board) {
        solve01(board);
    }

    private int m;
    private int n;

    /**
     * Optimisation: mark visited cells in place instead of allocating unsurrounded
     *
     */
    private void solve01(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] unsurrounded = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == MARKER_O) {
                search(i, 0, board, unsurrounded);
            }
            if (board[i][n-1] == MARKER_O) {
                search(i, n-1, board, unsurrounded);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == MARKER_O) {
                search(0, j, board, unsurrounded);
            }
            if (board[m-1][j] == MARKER_O) {
                search(m-1, j, board, unsurrounded);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == MARKER_O && !unsurrounded[i][j]) {
                    board[i][j] = MARKER_X;
                }
            }
        }
    }

    private void search(int i, int j, char[][] board, boolean[][] unsurrounded) {
        unsurrounded[i][j] = true;

        if (i > 0 && board[i-1][j] == MARKER_O && !unsurrounded[i-1][j]) {
            search(i-1, j, board, unsurrounded);
        }
        if (i < m - 1  && board[i+1][j] == MARKER_O && !unsurrounded[i+1][j]) {
            search(i+1, j, board, unsurrounded);
        }
        if (j > 0 && board[i][j-1] == MARKER_O && !unsurrounded[i][j-1]) {
            search(i, j-1, board, unsurrounded);
        }
        if (j < n - 1 && board[i][j+1] == MARKER_O && !unsurrounded[i][j+1]) {
            search(i, j+1, board, unsurrounded);
        }
    }

    private static final char MARKER_O = 'O';
    private static final char MARKER_X = 'X';
}
