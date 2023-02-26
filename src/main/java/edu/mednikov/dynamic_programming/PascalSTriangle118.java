package edu.mednikov.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">description</a>
 */
public class PascalSTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            List<Integer> currLvl = new ArrayList<>();
            if (n == 0) {
                currLvl.add(1);
            } else if (n == 1) {
                currLvl.add(1);
                currLvl.add(1);
            } else {
                currLvl.add(1);
                for (int i = 1; i < n; i++) {
                    currLvl.add(result.get(n - 1).get(i-1) + result.get(n - 1).get(i));
                }
                currLvl.add(1);
            }
            result.add(currLvl);
        }
        return result;
    }
}
