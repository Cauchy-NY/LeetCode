package Medium;

public class Question240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        for (int i = 0, j = matrix[0].length-1; i < matrix.length && j >= 0;) {
            if (target == matrix[i][j])
                return true;
            else if (target > matrix[i][j])
                i++;
            else
                j--;
        }
        return false;
    }
}
