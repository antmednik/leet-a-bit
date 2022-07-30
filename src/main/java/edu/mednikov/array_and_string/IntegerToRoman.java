package edu.mednikov.array_and_string;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int n = num;
        append(roman, n / 1000, 'M');
        n %= 1000;

        append(roman, n / 100, 'C', 'D', 'M');
        n %= 100;

        append(roman, n / 10, 'X', 'L', 'C');
        n %= 10;

        append(roman, n, 'I', 'V', 'X');

        return roman.toString();
    }

    private void append(StringBuilder roman, int n, char d1, char d5, char d10) {
        if (n < 4) {
            append(roman, n, d1);
        } else if (n == 4) {
            roman.append(d1);
            roman.append(d5);
        } else if (n >= 5 && n < 9) {
            roman.append(d5);
            append(roman, n - 5, d1);
        } else if (n == 9) {
            roman.append(d1);
            roman.append(d10);
        }
    }

    private void append(StringBuilder sb, int n, char c) {
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
    }
}
