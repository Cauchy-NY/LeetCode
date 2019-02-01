package Medium;

public class Question73 {
    public void setZeroes(int[][] matrix) {
        boolean freeRow = false, freeCol = false;
        // mark
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        freeRow = true;
                    if (j == 0)
                        freeCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // free
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (freeRow) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if(freeCol) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
