package edu.mednikov.bit_manipulation;

/**
 * <a href="https://leetcode.com/problems/power-of-two/">https://leetcode.com/problems/power-of-two/</a>
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int onesCount = 0;
        while (n > 0) {
            onesCount += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return onesCount == 1;
    }
}
