package edu.mednikov.array_and_string;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int prevSpace = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                int start = s.charAt(i) == ' ' ? i-1 : i;
                for (int j = start; j > prevSpace; j--) {
                    sb.append(s.charAt(j));
                }
                if (s.charAt(i) == ' ') sb.append(' ');
                prevSpace = i;
            }
        }
        return sb.toString();
    }
}
