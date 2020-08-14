package DFSBFS;

/**
 * From: https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands (Medium)
 */
public class NumberOfIslands {
    final char LAND = '1';
    final char WATER = '0';
    final int[] direX = {0, 0, -1, 1};
    final int[] direY = {-1, 1, 0, 0};
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int numRow = grid.length;
        int numCol = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[numRow][numCol];
        for (int i=0; i<numRow; i++) {
            for (int j=0; j<numCol; j++) {
                if (!visited[i][j] && grid[i][j] == LAND) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (visited[i][j] || grid[i][j] == WATER) {
            return;
        }
        visited[i][j] = true;
        for (int d=0; d<4; d++) {
            bfs(grid, visited, i + direX[d], j + direY[d]);
        }
    }
}
