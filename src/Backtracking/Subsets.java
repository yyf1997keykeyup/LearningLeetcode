package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsetsVersion1(int[] nums) {
        for (int cap = 0; cap <= nums.length; cap++) {
            backtrack1(0, new ArrayList<>(), nums, cap);
        }
        return output;
    }
    public void backtrack1(int startIdx, ArrayList<Integer> curList, int[] nums, int capacity) {
        if (curList.size() == capacity) {
            output.add(new ArrayList<>(curList));
        }
        for (int i = startIdx; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack1(i + 1, curList, nums, capacity);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsVersion2(int[] nums) {
        backtrack2(0, new ArrayList<>(), nums);
        return output;
    }
    public void backtrack2(int startIdx, ArrayList<Integer> curList, int[] nums) {
        output.add(new ArrayList<>(curList));
        for (int i = startIdx; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack2(i + 1, curList, nums);
            curList.remove(curList.size() - 1);
        }
    }
}
