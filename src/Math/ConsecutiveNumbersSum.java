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

    public int consecutiveNumbersSumBetter(int N) {
        int count = 0;
        int iMax = (int) (Math.sqrt(2 * N + 1 / 4) - 1 / 2);
        for (int i = 1; i <= iMax; i++) {
            if ((N - i * (i + 1) / 2) % i == 0) {
                count++;
            }
        }
        return count;
    }
}
