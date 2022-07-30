package edu.mednikov.array_and_string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/01-matrix/">https://leetcode.com/problems/01-matrix/</a>
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];
        for (short r = 0; r < m; r++) {
            for (short c = 0; c < n; c++) {
                result[r][c] = mat[r][c] == 0 ? 0 : -1;
            }
        }

        for (short r = 0; r < m; r++) {
            for (short c = 0; c < n; c++) {
                if (result[r][c] == 0) continue;
                result[r][c] = getShortestPath(result, new Point(r, c));
            }
        }

        return result;
    }

    /**
     *  0   0  0
     *  0  -1  0
     * -1  -1 -1
     * */
    private int getShortestPath(int[][] result, Point p) {
        short r = p.r;
        short c = p.c;
        if (result[r][c] > -1) return result[r][c];

        int m = result.length;
        int n = result[0].length;
        List<Point> undiscoveredCandidates = new ArrayList<>(4);
        List<Point> discoveredCandidates = new ArrayList<>(4);
        if (r > 0) {
            int value = result[r-1][c];
            if (value == 0) {
                return result[r][c] = 1;
            } else {
                Point candidate = new Point((short) (r - 1), c);
                if (value == -1) {
                    undiscoveredCandidates.add(candidate);
                } else {
                    discoveredCandidates.add(candidate);
                }
            }
        }
        if (r < m - 1) {
            int value = result[r+1][c];
            if (value == 0) {
                return result[r][c] = 1;
            } else {
                Point candidate = new Point((short) (r + 1), c);
                if (value == -1) {
                    undiscoveredCandidates.add(candidate);
                } else {
                    discoveredCandidates.add(candidate);
                }
            }
        }
        if (c > 0) {
            int value = result[r][c-1];
            if (value == 0) {
                return result[r][c] = 1;
            } else {
                Point candidate = new Point(r, (short) (c-1));
                if (value == -1) {
                    undiscoveredCandidates.add(candidate);
                } else {
                    discoveredCandidates.add(candidate);
                }
            }
        }
        if (c < n - 1) {
            int value = result[r][c+1];
            if (value == 0) {
                return result[r][c] = 1;
            } else {
                Point candidate = new Point(r, (short) (c+1));
                if (value == -1) {
                    undiscoveredCandidates.add(candidate);
                } else {
                    discoveredCandidates.add(candidate);
                }
            }
        }
        if (!undiscoveredCandidates.isEmpty()) {
            for (Point ucp : undiscoveredCandidates) {
                getShortestPath(result, ucp);
                discoveredCandidates.add(ucp);
            }
        }
        return result[r][c] = discoveredCandidates.stream()
                .map(dcp -> result[dcp.r][dcp.c])
                .min(Comparator.naturalOrder()).get() + 1;
    }

    static class Point {
        public final short r;
        public final short c;
        public Point(short r, short c) {
            this.r = r;
            this.c = c;
        }
    }
}
