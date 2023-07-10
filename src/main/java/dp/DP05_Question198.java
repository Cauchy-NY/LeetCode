package dp;

public class DP05_Question198 {

    // 1 <= nums.length <= 100
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
//        if (nums.length == 0) return 0;
//        int[] memo = new int[nums.length + 1];
//        memo[0] = 0;
//        memo[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
//        }
//        return memo[nums.length];
    }

    public static void main(String[] args) {
        DP05_Question198 question = new DP05_Question198();
        System.out.println(question.rob(new int[]{1, 2, 3, 1}));
        System.out.println(question.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(question.rob(new int[]{2, 1, 1, 2}));
    }
}
