package BitMap;

import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/prison-cells-after-n-days/
 * 957. Prison Cells After N Days (Medium)
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> cache = new HashMap<>();
        boolean fastForwarded = false;

        int stateBitmap = 0x0;
        for (int cell : cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }

        while (N > 0) {
            if (!fastForwarded) {
                if (cache.containsKey(stateBitmap)) {
                    N %= cache.get(stateBitmap) - N;
                    fastForwarded = true;
                } else {
                    cache.put(stateBitmap, N);
                }
            }
            if (N > 0) {
                N -= 1;
                // get the bitmap of the next day
                stateBitmap = ~((stateBitmap << 1) ^ (stateBitmap >> 1));
                stateBitmap = stateBitmap & 0x7e;
            }
        }
        int[] output = new int[cells.length];
        for (int i = cells.length - 1; i >= 0; i--) {
            output[i] = (stateBitmap & 0x1);
            stateBitmap = stateBitmap >> 1;
        }
        return output;
    }
}
