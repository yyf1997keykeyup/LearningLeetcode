package DP;

/**
 * From: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 121. Best Time to Buy and Sell Stock (Easy)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int dayNum = prices.length;
        if (dayNum == 0) {
            return 0;
        }
        int[][] dp = new int[dayNum][2];
        dp[0][0] = 0;
        // = max(dp[-1][0], dp[-1][1] + prices[i])
        // = max(0, -infinity + prices[i]) = 0
        dp[0][1] = -prices[0];
        // = max(dp[-1][1], dp[-1][0] - prices[i])
        // = max(-infinity, 0 - prices[i]) = -prices[i]
        for (int i = 1; i < dayNum; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[dayNum - 1][0];
    }
}
