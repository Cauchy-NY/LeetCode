package Hard;

public class Question329 {
    // 评论区dalao的解答
    // 同样是记忆化搜索，更简洁：边界判断、dfs方向变常量
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    // 记忆化搜索，自己有点僵的思路
    public int longestIncreasingPath_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int [][] maxLenArray = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (maxLenArray[i][j] != 0)
                    maxLen = Math.max(maxLen, maxLenArray[i][j]);
                else
                    maxLen = Math.max(maxLen, findMaxWay(matrix, maxLenArray, i, j));
            }
        }
        return maxLen;
    }

    private int findMaxWay(int[][] matrix, int [][] maxLenArray, int i, int j) {
        if (maxLenArray[i][j] != 0)
            return maxLenArray[i][j];

        int maxLen = 1;
        if (i-1 >= 0 && matrix[i-1][j] > matrix[i][j])
            maxLen = Math.max(maxLen, findMaxWay(matrix, maxLenArray, i-1, j)+1);
        if (j-1 >= 0 && matrix[i][j-1] > matrix[i][j])
            maxLen = Math.max(maxLen, findMaxWay(matrix, maxLenArray, i, j-1)+1);
        if (i+1 < matrix.length && matrix[i+1][j] > matrix[i][j])
            maxLen = Math.max(maxLen, findMaxWay(matrix, maxLenArray, i+1, j)+1);
        if (j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j])
            maxLen = Math.max(maxLen, findMaxWay(matrix, maxLenArray, i, j+1)+1);

        maxLenArray[i][j] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        new Question329().longestIncreasingPath(matrix);
    }
}
