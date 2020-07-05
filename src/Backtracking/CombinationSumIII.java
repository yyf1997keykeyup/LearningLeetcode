package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), 0, 1, n, k);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> curList, int curSum, int start, int targetSum, int cap) {
        if (curList.size() == cap && curSum == targetSum) {
            output.add(new ArrayList<>(curList));
        }
        for (int i = start; i <= 9; i++) {
            curList.add(i);
            backtrack(output, curList, curSum+i, i + 1, targetSum, cap);
            curList.remove(curList.size() - 1);
        }
    }
}
