package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question54 {
    // 巧妙的设置四个转折点，discuss
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++)
                res.add(matrix[rowBegin][j]);
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++)
                res.add(matrix[j][colEnd]);
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--)
                    res.add(matrix[rowEnd][j]);
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--)
                    res.add(matrix[j][colBegin]);
            }
            colBegin ++;
        }
        return res;
    }
//    递归 dead
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        if (matrix == null || matrix.length == 0)
//            return res;
//        backtrack(res, matrix);
//        return res;
//    }
//
//    private void backtrack(List<Integer> res, int[][] matrix) {
//        for (int i = 0; i < matrix[0].length-1; i++)
//            res.add(matrix[0][i]);
//        for (int i = 0; i < matrix.length-1; i++)
//            res.add(matrix[i][matrix[0].length-1]);
//        for (int i = matrix[0].length-1; i > 0; i--)
//            res.add(matrix[matrix.length-1][i]);
//        for (int i = matrix.length-1; i >= 1; i--)
//            res.add(matrix[i][0]);
//
//        if (matrix.length == 1 && matrix[0].length == 1) {
//            res.add(matrix[0][0]);
//            return;
//        } else if (matrix.length <= 2 || matrix[0].length <= 2)
//            return;
//        else if (matrix.length == 3 && matrix[0].length == 3) {
//            res.add(matrix[1][1]);
//            return;
//        } else
//            backtrack(res, getInnerMatrix(matrix));
//    }
//
//    private int[][] getInnerMatrix(int[][] matrix) {
//        int[][] newMatrix = new int[matrix.length-2][matrix[0].length-2];
//        for (int i = 0; i < newMatrix.length; i++) {
//            for (int j = 0; j < newMatrix[0].length; j++) {
//                newMatrix[i][j] = matrix[i+1][j+1];
//            }
//        }
//        return newMatrix;
//    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//            {1, 2, 3, 4},
//            {5, 6, 7, 8},
//            {9, 10, 11, 12}
//        };
//        int[][] matrix = new int[][] {
//            {1, 2},
//            {3, 4},
//        };
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        int[][] matrix = new int[][]{
//                {6,9,7},
//        };
        List<Integer> res = new Question54().spiralOrder(matrix);
        for (Integer i: res)
            System.out.print(i+" ");
    }
}
