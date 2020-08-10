package DP;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/super-egg-drop/
 * 887. Super Egg Drop (Hard)
 */
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int n = 0;
        while (dp[n][K] < N) {
            n++;
            for (int k = 1; k <= K; k++) {
                dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k] + 1;
            }
        }
        return n;
    }

    public int superEggDropNotPass(int K, int N) {
        Map<String, Integer> memo = new HashMap<>();
        return recur(K, N, memo);
    }

    private int recur(int K, int N, Map<String, Integer> memo) {
        if (N == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        String key = KN2Key(K, N);
        if (!memo.containsKey(key)) {
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                res = Math.min(res, Math.max(recur(K, N - i, memo), recur(K - 1, i - 1, memo)) + 1);
            }
            memo.put(key, res);
        }
        return memo.get(key);
    }

    private String KN2Key(int K, int N) {
        return K + "#" + N;
    }
}
