package DP;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int row=1; row<n; row++) {
            for (int i=1; i<m; i++) {
                dp[i] = dp[i] + dp[i-1];
            }
        }
        return dp[m-1];
    }
}
