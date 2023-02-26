package edu.mednikov.dynamic_programming;

public class FibonacciNumber509 {
    public int fib(int n) {
        if (n == 0) return 0;

        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
