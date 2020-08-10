package WeeklyContest;

public class Contest201 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (sb.length() == 0) {
                sb.append(s.charAt(i));
                continue;
            }
            if (sb.charAt(sb.length()-1) - 32 == s.charAt(i) || sb.charAt(sb.length()-1) + 32 == s.charAt(i)) {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public char findKthBit(int n, int k) {
        k--;
        int len = (int) (Math.pow(2, n) - 1);
        int midIdx = (int) (Math.pow(2, n-1) - 1);

        if (n == 1) {
            return '0';
        }
        if (k == midIdx) {
            return '1';
        } else if (k < midIdx) {
            return findKthBit(n-1, k+1);
        } else {
            return findKthBit(n-1, len - k) == '1' ? '0' : '1';
        }
    }

    /** 3,4: Python Version
     * from functools import lru_cache
     *
     *
     * class Solution:
     *
     *     def maxNonOverlapping(self, nums: [int], target: int) -> int:
     *         res = 0
     *         pre = {0}
     *
     *         p = 0
     *         for n in nums:
     *             p += n
     *             if p - target in pre:
     *                 res += 1
     *                 p = 0
     *                 pre = {0}
     *             else:
     *                 pre.add(p)
     *
     *         return res
     *
     *     # do not pass (TLE)
     *     def maxNonOverlappingDP(self, nums: [int], target: int) -> int:
     *         self.nums = nums
     *         self.origin_target = target
     *
     *         @lru_cache(None)
     *         def dp(i: int, target: int) -> int:
     *             if i >= len(self.nums):
     *                 return 0
     *             ret = max(dp(i + 1, target - self.nums[i]), dp(i + 1, self.origin_target))
     *             if target == self.nums[i]:
     *                 ret = max(ret, 1 + dp(i + 1, self.origin_target))
     *             return ret
     *
     *         return dp(0, target)
     *
     *     def minCost(self, n: int, cuts: [int]) -> int:
     *         @lru_cache(None)
     *         def dp(i, j):
     *             res = float('inf')
     *             for c in cuts:
     *                 if c > i and c < j:
     *                     res = min(res, dp(i, c) + dp(c, j) + j - i)
     *             if res == float('inf'):
     *                 return 0
     *             return res
     *
     *         return dp(0, n)
     */
}
