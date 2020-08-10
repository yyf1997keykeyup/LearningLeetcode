package DP;

/**
 * From: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 188. Best Time to Buy and Sell Stock IV (Hard)
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int dayNum = prices.length;
        if (dayNum == 0) {
            return 0;
        }
        if (k > dayNum / 2) {
            return maxProfit_k_inf(prices);
        }
        int[][][] dp = new int[dayNum][k + 1][2];
        for (int i = 0; i < dayNum; i++) {
            for (int kk = 1; kk <= k; kk++) {
                if (i == 0) {
                    // base cases
                    dp[i][kk][0] = 0;
                    dp[i][kk][1] = -prices[i];
                } else {
                    // transfer functions
                    dp[i][kk][0] = Math.max(dp[i-1][kk][0], dp[i-1][kk][1]   + prices[i]);
                    dp[i][kk][1] = Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0] - prices[i]);
                }
            }
        }
        return dp[dayNum - 1][k][0];
    }

    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cached_dp_i_0 = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, cached_dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
