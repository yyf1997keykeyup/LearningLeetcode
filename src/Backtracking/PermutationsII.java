package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(output, new ArrayList<>(), nums, new boolean[nums.length]);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> curList, int[] nums, boolean[] used) {
        if (curList.size() == nums.length) {
            output.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            curList.add(nums[i]);
            backtrack(output, curList, nums, used);
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
}
