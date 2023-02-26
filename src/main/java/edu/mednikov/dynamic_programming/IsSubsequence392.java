package edu.mednikov.dynamic_programming;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        return s(s, t);
    }

    private boolean s(String s, String t) {
        int ti = 0;
        int si;
        boolean lastEqual = false;
        for (si = 0; si < s.length() && ti < t.length(); si++) {
            lastEqual = false;
            char sc = s.charAt(si);
            while (ti < t.length()) {
                if (sc == t.charAt(ti++)) {
                    lastEqual = true;
                    break;
                }
            }
        }
        return si == s.length() && lastEqual;
    }
}
