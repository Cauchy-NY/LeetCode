package dp;

import java.util.Arrays;

public class DP09_Question45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            int end = Math.min(dp.length - 1, i + nums[i]);
            for (int j = i + 1; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        DP09_Question45 question = new DP09_Question45();
        System.out.println(question.jump(new int[]{0}));
        System.out.println(question.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(question.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
