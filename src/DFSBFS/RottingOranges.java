package DFSBFS;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * From: https://leetcode.com/problems/rotting-oranges/
 * 994. Rotting Oranges (Medium)
 */
public class RottingOranges {
    final int[] direX = new int[]{0,0,-1,1};
    final int[] direY = new int[]{-1,1,0,0};
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int numRow = grid.length;
        int numCol = grid[0].length;
        int minutes = 0;
        int freshCount = 0;
        for (int i=0; i<numRow; i++) {
            for (int j=0; j<numCol; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int turn=0; turn<size; turn++) {
                Pair<Integer, Integer> pair = queue.poll();
                int i = pair.getKey();
                int j = pair.getValue();
                for (int d=0; d<4; d++) {
                    int newY = direY[d] + i;
                    int newX = direX[d] + j;
                    if (newX >= 0 && newX < numCol && newY >=0 && newY < numRow) {
                        if (grid[newY][newX] == 1) {
                            grid[newY][newX] = 2;
                            freshCount--;
                            queue.offer(new Pair(newY, newX));
                            if (freshCount == 0) {
                                return minutes;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(freshCount);
        return -1;
    }
}
