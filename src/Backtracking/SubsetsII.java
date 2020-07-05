package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(output, new ArrayList<>(), nums, 0);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> curList, int[] nums, int startIdx) {
        output.add(new ArrayList<>(curList));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }
            curList.add(nums[i]);
            backtrack(output, curList, nums, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
