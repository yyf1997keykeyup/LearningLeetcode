package DP;

public class MaximumSubarray {
    /**
     * This is a simplified version of DP solution, saving space complexity to O(1).
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = nums[0];
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            int curr = Math.max(nums[i], nums[i] + prev);
            res = Math.max(res, curr);
            prev = curr;
        }
        return res;
    }
}
