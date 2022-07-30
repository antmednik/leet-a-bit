package edu.mednikov.array_and_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;

        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];

        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc));
        while (!q.isEmpty()) {
            Point p = q.pop();
            if (p.x > 0 && image[p.x - 1][p.y] == originalColor) {
                q.add(new Point(p.x - 1, p.y));
            }
            if (p.x < m-1 && image[p.x + 1][p.y] == originalColor) {
                q.add(new Point(p.x + 1, p.y));
            }
            if (p.y > 0 && image[p.x][p.y - 1] == originalColor) {
                q.add(new Point(p.x, p.y - 1));
            }
            if (p.y < n - 1 && image[p.x][p.y + 1] == originalColor) {
                q.add(new Point(p.x, p.y + 1));
            }
            image[p.x][p.y] = newColor;
        }

        return image;
    }

    static class Point {
        public final byte x;
        public final byte y;

        public Point(int x, int y) {
            this.x = (byte)x;
            this.y = (byte)y;
        }
    }
}
