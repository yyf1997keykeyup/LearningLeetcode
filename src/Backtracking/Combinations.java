package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), 1, n, k);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> curList, int start, int end, int cap) {
        if (curList.size() == cap) {
            output.add(new ArrayList<>(curList));
        }
        for (int i = start; i <= end; i++) {
            curList.add(i);
            backtrack(output, curList, i + 1, end, cap);
            curList.remove(curList.size() - 1);
        }
    }
}
