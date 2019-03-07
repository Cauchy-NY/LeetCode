package Medium;

import Design.NumMatrix;

public class Question304 {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);

        numMatrix.sumRegion(2, 1, 4, 3); // -> 8
        numMatrix.sumRegion(1, 1, 2, 2); // -> 11
        numMatrix.sumRegion(1, 2, 2, 4); // -> 12
    }
}
