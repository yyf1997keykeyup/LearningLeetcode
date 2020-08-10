package Math;

/**
 * From: https://leetcode.com/problems/consecutive-numbers-sum/
 * 829. Consecutive Numbers Sum (hard)
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int res = 1;
        int n = 2;
        while (n * (1 + n) / 2 <= N) {
            if (n % 2 == 0) {
                if ((N + n / 2) % n == 0) {
                    res++;
                }
            } else {
                if (N % n == 0) {
                    res++;
                }
            }
            n++;
        }
        return res;
    }
}
