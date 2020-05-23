package WeeklyContest;

import java.util.*;

public class Contest184 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sticks = new int[n];
        for (int i = 0; i < n; i++) {
            sticks[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(0);
        } else {
            int breakCount = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (sticks[i] > sticks[i + 1]) {
                    int cut = sticks[i] / sticks[i + 1] + 1;
                    int left = sticks[i] / cut;
                    breakCount += cut - 1;
                    sticks[i] = left;
                }
            }
            System.out.println(breakCount);
        }
    }
}
