package Easy;

public class Question292 {
    // 结果
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // 原因，会超内存
    public boolean canWinNim_2(int n) {
        if (n <= 3) return true;
        if (n == 4) return false;
        boolean[] dp = new boolean[n+1];
        dp[1] = dp[2] = dp[3] = true;
        for (int i = 5; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (!dp[i-j])
                    dp[i] = true;
            }
        }
        return dp[n];
    }
}
