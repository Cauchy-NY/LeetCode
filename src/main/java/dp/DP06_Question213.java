package dp;

public class DP06_Question213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(calLinerDP(nums, 0, nums.length - 2), calLinerDP(nums, 1, nums.length - 1));
    }

    private int calLinerDP(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        DP06_Question213 question = new DP06_Question213();
        System.out.println(question.rob(new int[]{2, 3, 2}));
        System.out.println(question.rob(new int[]{1, 2, 3, 1}));
        System.out.println(question.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(question.rob(new int[]{2, 1, 1, 2}));
    }
}
