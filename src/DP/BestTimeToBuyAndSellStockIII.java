package DP;

/**
 * From: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 123. Best Time to Buy and Sell Stock III (Hard)
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int dayNum = prices.length;
        if (dayNum == 0) {
            return 0;
        }
        int max_k = 2;
        int[][][] dp = new int[dayNum][max_k + 1][2];
        for (int i = 0; i < dayNum; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i == 0) {
                    // base cases
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                } else {
                    // transfer functions
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]   + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }
            }
        }
        return dp[dayNum - 1][max_k][0];
    }
}
