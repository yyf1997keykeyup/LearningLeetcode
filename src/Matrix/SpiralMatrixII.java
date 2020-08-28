package Matrix;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int curr = 1;
        int[][] dire = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int i=0, j=0, d=0;
        while (curr <= n * n) {
            mat[i][j] = curr++;
            int nextI = i + dire[d][0];
            int nextJ = j + dire[d][1];
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || mat[nextI][nextJ] != 0) {
                d = (d + 1) % 4;
            }
            i = i + dire[d][0];
            j = j + dire[d][1];
        }
        return mat;
    }
}
