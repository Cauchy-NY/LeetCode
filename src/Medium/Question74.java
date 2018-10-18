package Medium;

public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = matrix[mid/n][mid%n];
            if (tmp == target)
                return true;
            else if (tmp < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
