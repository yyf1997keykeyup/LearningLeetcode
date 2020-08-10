package DP;

/**
 * From: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 714. Best Time to Buy and Sell Stock with Transaction Fee (Medium)
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int dayNum = prices.length;
        if (dayNum == 0) {
            return 0;
        }
        int[][] dp = new int[dayNum][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dayNum; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[dayNum - 1][0];
    }
}
