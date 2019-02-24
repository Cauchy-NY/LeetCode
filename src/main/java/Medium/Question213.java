package Medium;

import java.util.Arrays;

public class Question213 {
    public int rob(int[] nums) {
        // 动态规划，在 198 号问题基础上修改
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            // 考虑不抢劫 0 号房间和不抢劫 n-1 号房间的情况
            return Math.max(lineRob(Arrays.copyOfRange(nums, 0, nums.length-1)),
                    lineRob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

    }

    private int lineRob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
        int[] memo = new int[n];
        // 先考虑最简单的情况
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
            memo[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : memo[i + 2]),
                    nums[i + 1] + (i + 3 >= n ? 0 : memo[i + 3]));
        }
        return memo[0];
    }
}
