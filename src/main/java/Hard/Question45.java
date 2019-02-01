package Hard;

import java.util.ArrayList;
import java.util.List;

public class Question45 {
    public int jump(int[] nums) {
        int times = 0;  // 跳了多少次
        int reached = 0;  // 当前跳了times次时能到的最远范围
        int max = 0;  // 路过的位置之处再跳一次能到达的最远的位置
        // 贪心，reached和times表示跳了times次后，某一段区间内最小的步伐到达数量
        for (int i = 0; i < nums.length; i++) {
            if(reached < i) {
                times++;
                reached = max;
            }
            max = Math.max(max, i+nums[i]);
        }
        return times;
    }


//    TLE的dp orz
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];  // dp[i] 为到达 i 位置的最小跳数
//        dp[0] = 0;  // 到达下标0的最小跳数是0
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (i - j <= nums[j])
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//            }
//        }
//        return dp[nums.length - 1];
//    }


//    TLE的dfs orz
//    public int jump(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        backtrack(res, nums, 0, 0);
//        res.sort(Integer::compareTo);
//        return res.get(0);
//    }
//
//    private void backtrack(List<Integer> list, int[] nums, int index, int step) {
//        if (index == nums.length-1)
//            list.add(step);
//        else {
//            for (int i = 1; i <= nums[index]; i++) {
//                if (index + i < nums.length)
//                    backtrack(list, nums, index+i, step+1);
//            }
//        }
//    }
}
