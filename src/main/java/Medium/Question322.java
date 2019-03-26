package Medium;

public class Question322 {
    // 回溯+记忆化搜索
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return backtrack(coins, amount, new int[amount]);
    }

    private int backtrack(int[] coins, int remain, int[] count) {  // remain: remaining coins after the last step; count[remain]: minimum number of coins to sum up to remain
        if (remain < 0) return -1;  // not valid
        if (remain == 0) return 0;  // completed
        if (count[remain-1] != 0) return count[remain-1];  // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int res = backtrack(coins, remain-coin, count);
            if (res >= 0 && res < min)
                min = 1+res;
        }
        count[remain-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return count[remain-1];
    }

    // dp
    public int coinChange_2(int[] coins, int amount) {
        if (amount < 1)
            return 0;

        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int min = -1;
            for (int coin: coins) {
                if (i >= coin && dp[i-coin] != -1) {
                    int temp = dp[i-coin]+1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[i] = min;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        new Question322().coinChange_2(coins, 11);
    }
}
