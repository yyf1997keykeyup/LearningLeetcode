package DP;

/**
 * From: https://leetcode.com/problems/implement-strstr/
 * 28. Implement strStr() (Easy)
 */
public class ImplementStrStr {
    private int[][] dp;
    private String pat;

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        KMP(needle);
        return search(haystack);
    }

    /**
     * KMP from: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-zhi-kmp-zi-fu-pi-pei-suan-fa
     */
    public void KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[state][char] = next state
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // init the X state to 0
        int X = 0;
        // build the DFA
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // update the X state
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == M) return i - M + 1;
        }
        return -1;
    }
}
