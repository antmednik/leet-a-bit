package edu.mednikov.array_and_string;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">https://leetcode.com/problems/zigzag-conversion/</a>
 * */
public class ZigzagConversion {
    /*
    * Input: s = "PAYPALISHIRING", len(s)=14, numRows = 4
    * Output: "PINALSIGYAHRPI"
    * (n - 1) columns ~ (2*n - 2) symbols
    * Explanation:
    * P     I    N
    * A   L S  I G
    * Y A   H R
    * P     I
    * */

    public String convert(String s, int numRows) {
        return convert1(s, numRows);
    }

    /**
     * O(?) time and O(?) space
     * */
    private String convert1(String s, int n) {
        if (n == 1) return s;

        int patternsCount = s.length() / (2*n - 2);
        int colCount = patternsCount * (n-1);
        int tail = s.length() % (2*n - 2);
        if (tail > 0) {
            colCount++;
            if (tail > n) {
                colCount += tail - n;
            }
        }
        char[][] matrix = new char[n][colCount];
        boolean descending = true;
        for (int si = 0, col = 0, row = 0; si < s.length(); si++) {
            matrix[row][col] = s.charAt(si);
            if (descending) {
                if (row < n - 1) {
                    row++;
                } else {
                    descending = false;
                    row--;
                    col++;
                }
            } else {
                if (row > 0) {
                    row--;
                    col++;
                } else {
                    descending = true;
                    row++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] != '\u0000') {
                    sb.append(matrix[row][col]);
                }
            }
        }
        return sb.toString();
    }

    /*
    Solution
Approach 1: Sort by Row
Intuition

By iterating through the string from left to right, we can easily determine which row in the Zig-Zag pattern that a character belongs to.

Algorithm

We can use \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) lists to represent the non-empty rows of the Zig-Zag Pattern.

Iterate through ss from left to right, appending each character to the appropriate row. The appropriate row can be tracked using two variables: the current row and the current direction.

The current direction changes only when we moved up to the topmost row or moved down to the bottommost row.


Complexity Analysis

Time Complexity: O(n)O(n), where n == \text{len}(s)n==len(s)
Space Complexity: O(n)O(n)

Approach 2: Visit by Row
Intuition

Visit the characters in the same order as reading the Zig-Zag pattern line by line.

Algorithm

Visit all characters in row 0 first, then row 1, then row 2, and so on...

For all whole numbers kk,

Characters in row 00 are located at indexes k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2)
Characters in row \text{numRows}-1numRows−1 are located at indexes k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1
Characters in inner row ii are located at indexes k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i and (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i.

Complexity Analysis

Time Complexity: O(n)O(n), where n == \text{len}(s)n==len(s). Each index is visited once.
Space Complexity: O(n)O(n). For the cpp implementation, O(1)O(1) if return string is not considered extra space.
    * */
}
