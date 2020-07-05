package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), candidates, 0, 0, target);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> curList, int[] candidates, int startIdx, int curSum, int target) {
        if (curSum == target) {
            output.add(new ArrayList<>(curList));
        } else if (curSum > target) {
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            curList.add(candidates[i]);
            backtrack(output, curList, candidates, i, curSum + candidates[i], target);
            curList.remove(curList.size() - 1);
        }
    }
}
