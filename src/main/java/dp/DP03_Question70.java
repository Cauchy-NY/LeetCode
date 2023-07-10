package dp;

public class DP03_Question70 {

    // 1 <= n <= 45
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        DP03_Question70 question = new DP03_Question70();
        System.out.println(question.climbStairs(3));
    }
}
