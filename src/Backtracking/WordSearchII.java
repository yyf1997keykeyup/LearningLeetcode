package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * From: https://leetcode.com/problems/word-search-ii/
 * 212. Word Search II (Hard)
 */
public class WordSearchII {
    char[][] board;
    boolean[][] visited;
    char[] chars;
    int[] rowOffsets = {0, 1, 0, -1};
    int[] colOffsets = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> found = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                found.add(word);
            }
            this.visited = new boolean[board.length][board[0].length];
        }
        return found;

    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0] && backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int k) {
        if (k == chars.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (this.visited[i][j]) {
            return false;
        }
        for (int d = 0; d < 4; d++) {
            int newRow = i + rowOffsets[d];
            int newCol = j + colOffsets[d];
            this.visited[i][j] = true;
            if (board[i][j] == chars[k] && backtrack(newRow, newCol, k + 1)) {
                return true;
            }
            this.visited[i][j] = false;
        }
        return false;
    }
}
