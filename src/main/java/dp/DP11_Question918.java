package dp;

public class DP11_Question918 {

    /**
     * 1.子数组不包括数组的头和尾（除了最大和是整个数组的情况），意思就是说没有环；
     * 对于这种情况，解法和53.最大数组和的解法一样
     * 2.第二种情况则是包含环，也就是子数组包含数组头和尾元素；
     * 这种情况下，整个数组的和sum减去数组中间(1~n-1)最小序列和的值的差值是最大的，比没有环的时候还大
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = nums[0], sum = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }

        int min = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1] + nums[i]);
            min = Math.min(dp[i], min);
        }

        return Math.max(sum - min, max);
    }

    public static void main(String[] args) {
        DP11_Question918 question = new DP11_Question918();
        System.out.println(question.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(question.maxSubarraySumCircular(new int[]{5, -3, 5}));
    }
}
