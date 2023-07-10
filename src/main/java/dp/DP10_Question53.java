package dp;

public class DP10_Question53 {

    // dp数组是指帮助理解，实际上可以去掉
    // dp[i]为以nums[i]结尾的最大子数组和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        DP10_Question53 question = new DP10_Question53();
        System.out.println(question.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(question.maxSubArray(new int[]{1}));
        System.out.println(question.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
