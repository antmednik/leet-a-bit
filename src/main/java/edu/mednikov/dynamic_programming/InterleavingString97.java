package edu.mednikov.dynamic_programming;

public class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

        return try1(s1, s2, s3);
    }

    private boolean try1(String s1, String s2, String s3) {
        return try1Rec(s1, s2, s3, 0, 0);
    }

    private boolean try1Rec(String s1, String s2, String s3, int i, int j) {
        int k = i + j;
        if (k == s3.length()) return true;

        char s1c = s1.charAt(i);
        char s3c = s3.charAt(k);
        if (s1c == s3c) {
            if (i < s1.length() - 1 && try1Rec(s1, s2, s3, i+1, j)) return true;
        }
        char s2c = s2.charAt(j);
        if (s2c == s3c) {
            if (j < s2.length() - 1 && try1Rec(s1, s2, s3, i, j+1)) return true;
        }
        return false;
    }
}
