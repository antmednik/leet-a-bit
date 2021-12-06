package edu.mednikov.backtracking;

import java.util.*;

/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations
* that the number could represent. Return the answer in any order.
*
* A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*
* Example 1:
* Input: digits = "23"
* Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*
* Example 2:
* Input: digits = ""
* Output: []
*
* Example 3:
* Input: digits = "2"
* Output: ["a","b","c"]
*
* Constraints:
* 0 <= digits.length <= 4
* digits[i] is a digit in the range ['2', '9'].
* */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, Set<Character>> map = Map.of(
            '2', Set.of('a', 'b', 'c'),
            '3', Set.of('d', 'e', 'f'),
            '4', Set.of('g', 'h', 'i'),
            '5', Set.of('j', 'k', 'l'),
            '6', Set.of('m', 'n', 'o'),
            '7', Set.of('p', 'q', 'r', 's'),
            '8', Set.of('t', 'u', 'v'),
            '9', Set.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits.isEmpty()) return result;

        int solutionSize = 0;
        char[] solution = new char[digits.length()];

        addToSolution(digits.toCharArray(), solution, solutionSize, digits.length(), result);

        return result;
    }

    private void addToSolution(char[] input, char[] solution, int solutionSize, int targetSolutionSize,
                               List<String> solutions) {
        if (solutionSize == targetSolutionSize) {
            solutions.add(new String(solution));
            return;
        }

        for (var d : map.get(input[solutionSize])) {
            solution[solutionSize] = d;
            addToSolution(input, solution, solutionSize + 1, targetSolutionSize, solutions);
        }
    }
}
