package edu.mednikov.array_and_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfIsland {

    private static final int VISITED_MARK = 2;
    private static final int ISLAND_MARK = 1;
    private static final int WATER_MARK = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (byte c = 0; c < n; c++) {
            for (byte r = 0; r < m; r++) {
                if (grid[r][c] == WATER_MARK || grid[r][c] == VISITED_MARK) continue;
                int currArea = measureIsland(grid, r, c);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }

    private int measureIsland(int[][] grid, byte r, byte c) {
        Deque<Point> island = new ArrayDeque<>();
        island.add(new Point(r, c));
        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        while (!island.isEmpty()) {
            Point p = island.remove();
            if (grid[p.x][p.y] == VISITED_MARK) continue;

            area++;
            grid[p.x][p.y] = VISITED_MARK;
            if (p.x > 0 && grid[p.x-1][p.y] == ISLAND_MARK) {
                island.add(new Point((byte)(p.x - 1), p.y));
            }
            if (p.x < m - 1 && grid[p.x+1][p.y] == ISLAND_MARK) {
                island.add(new Point((byte)(p.x + 1), p.y));
            }
            if (p.y > 0 && grid[p.x][p.y-1] == ISLAND_MARK) {
                island.add(new Point(p.x, (byte)(p.y - 1)));
            }
            if (p.y < n - 1 && grid[p.x][p.y+1] == ISLAND_MARK) {
                island.add(new Point(p.x, (byte)(p.y + 1)));
            }
        }
        return area;
    }

    private static class Point{
        public final byte x;
        public final byte y;

        public Point(byte x, byte y) {
            this.x = x;
            this.y = y;
        }
    }
}
