package Medium;

public class Question221 {
    // 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方
    // 三个点也一定是某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。
    // 这是定性的判断，那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，
    // 最多比它的上方，左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，
    // 左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
    // 但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
    // 这时候只能取那三个正方形中最小的正方形的边长加1了。
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
                    result = Math.max(dp[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
