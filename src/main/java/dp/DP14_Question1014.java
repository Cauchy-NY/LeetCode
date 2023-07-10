package dp;

public class DP14_Question1014 {

    public int maxScoreSightseeingPair(int[] values) {
        if (values == null || values.length < 2) {
            return 0;
        }

        int[] dp = new int[values.length];
        int max = 0;

        dp[0] = 0;
        max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] - values[i - 1] + values[i] - 1, values[i - 1] + values[i] - 1);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 另一种思路：
     * sum = A[j] + A[i] + j - i = (A[i] - i) + (A[j] + j);
     * 开一个DP数组来表示数组A前i项的A[i] + i的最大值。
     * */

    public static void main(String[] args) {
        DP14_Question1014 question = new DP14_Question1014();
        System.out.println(question.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(question.maxScoreSightseeingPair(new int[]{1, 2}));
    }
}
