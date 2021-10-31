package edu.mednikov.array_and_string;

import java.util.Arrays;

/**
 * Set Matrix Zeroes
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column
 * to 0's, and return the matrix.
 * <p>
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * <p>
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        setZeroesMPlusN(matrix);
    }

    private void setZeroesMPlusN(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 || n == 1) {
            if (m == n) return;
            if (m == 1) {
                for (int j = 0; j < n; j++) {
                    if (matrix[0][j] == 0) {
                        for (int k = 0; k < n; k++) {
                            matrix[0][k] = 0;
                        }
                        break;
                    }
                }
                return;
            }
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][0] = 0;
                    }
                    break;
                }
            }
            return;
        }

        boolean setToZeroFirstRow = false, setToZeroFirstColumn = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                setToZeroFirstColumn = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                setToZeroFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = -1;
                    matrix[0][j] = -1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == -1 || matrix[0][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (setToZeroFirstColumn || matrix[i][0] == -1) {
                matrix[i][0] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            if (setToZeroFirstRow || matrix[0][j] == -1) {
                matrix[0][j] = 0;
            }
        }
    }
}
