package Medium;

public class Question48 {
    public void rotate(int[][] matrix) {
        // diagonal swap
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++)
                diagonalSwap(matrix, i, j);
        }
        // fold swap
        int lo = 0, hi = matrix.length-1;
        while (lo < hi) {
            for (int i = 0; i < matrix.length; i++)
                foldSwap(matrix, i, lo, hi);
            lo++;
            hi--;
        }
    }

    private void foldSwap(int[][] matrix, int i, int lo, int hi) {
        int tmp = matrix[i][lo];
        matrix[i][lo] = matrix[i][hi];
        matrix[i][hi] = tmp;
    }

    private void diagonalSwap(int[][] matrix, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
}
