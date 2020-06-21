package DP;

import java.util.Arrays;

public class HouseRobber {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] == -1) {
            memo[start] = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        }
        return memo[start];
    }
    public int robUpdated(int[] nums) {
        /*
         * O(1) space complexity.
         */
        int prevMax = 0;
        int currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + num, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
