package BinarySearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int hi = 1000000000;
        int lo = 1;
        while (lo < hi) {
            int mi = (lo + hi + 1) / 2;
            if (check(position, mi, m)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }

    private boolean check(int[] position, int minDist, int m) {
        int prev = position[0];
        int count = m - 1;
        int i = 1;
        while (i < position.length && count != 0) {
            if (position[i] - prev < minDist) {
                i++;
            } else {
                prev = position[i];
                count--;
            }
        }
        return count == 0;
    }
//
//    public static void main(String[] args) {
//        new MagneticForceBetweenTwoBalls().maxDistance(new int[]{1,2,3,4,7}, 3);
//    }
}
