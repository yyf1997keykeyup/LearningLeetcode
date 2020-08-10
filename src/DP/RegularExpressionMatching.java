package DP;

/**
 * From: https://leetcode.com/problems/regular-expression-matching/
 * 10. Regular Expression Matching (Hard)
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        // if do not match, assume the X* matches empty string
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        // one of: multiple/single/empty
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

/** Python Version
 * 1) DP table
 * class Solution:
 *     def isMatch(self, text, pattern) -> bool:
 *         memo = dict()
 *         def dp(i, j):
 *             if (i, j) in memo: return memo[(i, j)]
 *             if j == len(pattern): return i == len(text)
 *
 *             first = i < len(text) and pattern[j] in {text[i], '.'}
 *
 *             if j <= len(pattern) - 2 and pattern[j + 1] == '*':
 *                 ans = dp(i, j + 2) or first and dp(i + 1, j)
 *             else:
 *                 ans = first and dp(i + 1, j + 1)
 *
 *             memo[(i, j)] = ans
 *             return ans
 *
 *         return dp(0, 0)
 *
 *
 * 2) brute force
 * class Solution:
 *      def isMatch(text, pattern) -> bool:
 *          if not pattern: return not text
 *
 *          first = bool(text) and pattern[0] in {text[0], '.'}
 *
 *          if len(pattern) >= 2 and pattern[1] == '*':
 *              return isMatch(text, pattern[2:]) or first and isMatch(text[1:], pattern)
 *          else:
 *              return first and isMatch(text[1:], pattern[1:])
 */