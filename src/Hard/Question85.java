package Hard;

import java.util.Stack;

public class Question85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] ones = new int[m + 1][n];  // store the number of ones above directly
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i - 1][j] == '1')
                    ones[i][j] = ones[i-1][j] + 1;
                else
                    ones[i][j] = 0;
            }
            res = Math.max(res, largestRectangleArea(ones[i]));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];  // 为了全部出栈
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}
