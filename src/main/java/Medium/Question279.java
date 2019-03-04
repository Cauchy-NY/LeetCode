package Medium;

import java.util.Arrays;

public class Question279 {
    /**
     * 神奇的dp
     * dp[0] = 0
     * dp[1] = dp[0]+1 = 1
     * dp[2] = dp[1]+1 = 2
     * dp[3] = dp[2]+1 = 3
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     *       = Min{ dp[3]+1, dp[0]+1 }
     *       = 1
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     *       = Min{ dp[4]+1, dp[1]+1 }
     *       = 2
     * 						.
     * 						.
     * 						.
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     *        = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
     *        = 2
     * 						.
     * 						.
     * 						.
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; i - j*j >= 0; j++)
                min = Math.min(min, dp[i - j*j] + 1);

            dp[i] = min;
        }
        return dp[n];
    }

    // 渣渣的dfs，居然能过orz
    private int res = Integer.MAX_VALUE;

    public int numSquares_2(int n) {
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int sum) {
        if (n == 0 && sum < res) {
            res = sum;
            return;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = sqrt; i >= 1 && sum < res; i--, sum--) {
            backtrack(n - i * i, ++sum);
        }
    }
}
