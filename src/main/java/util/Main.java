package util;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        int[] dp = new int[m+1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && min > (dp[i - coins[j]] + 1))
                    min = dp[i - coins[j]] + 1;
            }
            dp[i] = min;
        }
        System.out.print(dp[m]);
    }
}
