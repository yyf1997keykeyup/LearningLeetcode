package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 2);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> curList, int n, int start) {
        if (n <= 1) {
            if (curList.size() > 1) {
                result.add(new ArrayList<>(curList));
            }
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                curList.add(i);
                backtrack(result, curList, n / i, i);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
