package DP;

public class BurstBalloons {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        for (int i=0; i<iNums.length; i++) {
            nums[i+1] = iNums[i];
        }
        nums[0] = nums[nums.length-1] = 1;
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 2; len < nums.length; ++len) {
            for (int left = 0; left < nums.length - len; ++left) {
                int right = left + len;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(
                            dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]
                    );
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
