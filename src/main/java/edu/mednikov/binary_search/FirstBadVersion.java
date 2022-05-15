package edu.mednikov.binary_search;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 *
 * Constraints:
 * 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion {

    private final int bad;

    public FirstBadVersion(int bad) {
        this.bad = bad;
    }

    /**
     * case 0 - [1]
     *
     * case 1 - [0, 0, 0, 0, 1, 1]
     * l    h   mid     isBad
     * 1    6   3       0
     * 3    6   4       0
     * 4    6   5       1
     * 4    5   4       0
     * l = 1 h = 6      mid = 3 isBad = 0
     * l = 3 h = 6      mid = 4 isBad = 0
     * l = 4 h = 6      mid = 5 isBad = 1
     * l = 4 h = 5      mid = 4 isBad = 0
     * l = 4 h = 5
     *
     *
     * case 2 - [0, 0, 1, 1, 1, 1]
     * l    h   mid     isBad
     * 1    6   3       1
     * 1    3   2       0   end
     *
     * case 3 - [0, 1]
     * l    h   mid     isBad
     * 1    2   1       0
     * 2    2   2       1
     *
     * case 4 - [1, 1]
     * l    h   mid     isBad
     * 1    2   1       1
     * 1    1   end
     *
     * [0, 0, 0, 1, 1]
     * 1    5   3   0
     * 4    5   4   1
     *
     *
     * [0, 1]
     * */
    public int firstBadVersion(int n) {
        if (n == 1) return 1;

        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int version) {
        return version >= bad;
    }
}
