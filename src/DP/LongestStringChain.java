package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/longest-string-chain/
 * 1048. Longest String Chain (Medium)
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int len = words.length;
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            wordMap.put(words[i], i);
        }
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (String candidate : getCandidates(words[i])) {
                if (wordMap.containsKey(candidate)) {
                    int prevIdx = wordMap.get(candidate);
                    dp[i] = Math.max(dp[i], dp[prevIdx] + 1);
                }
            }
        }
        int ret = dp[0];
        for (int i = 1; i < len; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    private String[] getCandidates(String word) {
        String[] candidates = new String[word.length()];
        candidates[0] = word.substring(0, word.length() - 1);
        for (int i = 1; i < word.length(); i++) {
            candidates[i] = word.substring(0, i - 1) + word.substring(i);
        }
        return candidates;
    }
}
