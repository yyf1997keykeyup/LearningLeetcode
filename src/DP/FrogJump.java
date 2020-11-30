package DP;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][1100];
        Map<Integer, Integer> stone2id = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            stone2id.put(stones[i], i);
        }
        helper(stones, stone2id, dp, 0, 0);
        for (int i = 0; i < 1100; i++) {
            if (dp[stones.length - 1][i]) {
                return true;
            }
        }
        return false;
    }

    public void helper(int[] stones, Map<Integer, Integer> stone2id, boolean[][] dp, int i, int k) {
        if (dp[i][k]) {
            return;
        }
        dp[i][k] = true;
        for (int kk = -1; kk <= 1; kk++) {
            if (k + kk > 0 && stone2id.containsKey(stones[i] + k + kk)) {
                helper(stones, stone2id, dp, stone2id.get(stones[i] + k + kk), k + kk);
            }
        }
    }
}
