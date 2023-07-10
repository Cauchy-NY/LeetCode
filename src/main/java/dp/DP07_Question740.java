package dp;

import java.util.Set;
import java.util.TreeMap;

public class DP07_Question740 {

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> set = map.keySet();
        if (set.isEmpty()) {
            return 0;
        }

        int index = 0;
        int[] dp = new int[set.size()];
        for (int k : set) {
            int v = map.get(k);
            if (index == 0) {
                dp[index] = k * v;
                index++;
                continue;
            }
            if (index == 1) {
                if (map.containsKey(k - 1)) {
                    dp[index] = Math.max(dp[0], k * v);
                } else {
                    dp[index] = dp[0] + k * v;
                }
                index++;
                continue;
            }

            if (map.containsKey(k - 1)) {
                dp[index] = Math.max(dp[index - 2] + k * v, dp[index - 1]);
            } else {
                dp[index] = dp[index - 1] + k * v;
            }
            index++;
        }
        return dp[dp.length - 1];
    }

//    // space trade time..
//    public int deleteAndEarn(int[] nums) {
//        int a[] = new int[10001];
//        for (int i : nums) {
//            a[i] += i;
//        }
//        int dp[] = new int[10001];
//        dp[0] = a[0];
//        dp[1] = Math.max(a[0], a[1]);
//        for (int i = 2; i <= 10000; i++) {
//            dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 1]);
//        }
//        return dp[10000];
//    }

    public static void main(String[] args) {
        DP07_Question740 question = new DP07_Question740();
        System.out.println(question.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(question.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
