package DP;

/**
 * From: https://leetcode.com/problems/decode-ways/
 * 91. Decode Ways (Medium)
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i=1; i<=len; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            }
            if (i-2 >= 0 && (s.charAt(i-2) == '1' || s.charAt(i-2) == '2')) {
                int num2 = Integer.parseInt(s.substring(i-2, i));
                if (num2 >= 10 && num2 <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len];
    }
}
