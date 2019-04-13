package Hard;

import java.util.Arrays;
import java.util.Comparator;

public class Question354 {
    // 参考 Question300 最长递增子序列
    // 只需要将长度排序（保证能装入该信封都在该信封前面）
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 1) return 0;

        int max = 1;
        int[] dp = new int[envelopes.length];

        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));

        for(int i = 1; i < envelopes.length; ++i) {
            for(int j = 0; j < i; ++j) {
                if(envelopes[i][0] == envelopes[j][0])
                    break;
                if(envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // O(NlogN)的做法, 按照长度升序, 同长则宽度降序排列, 然后使用O(logN)
    // 的最长递增子序列解法来做即可. 排序后等于把在二维(长、宽)上的最长递增子
    // 序列问题转换成一维(宽)上的最长递增子序列的查找, 因为对于长度来说已经满足递增
    // 只需要在宽度上也递增即为递增序列, 同长时按宽度降序排列的原因是避免同长时
    // 宽度小的也被列入递增序列中, 例如[3,3], [3,4]
    // 如果宽度也按升序来排列, [3,3]和[3,4]会形成递增序列, 而实际上不行.
    public int maxEnvelopes_2(int[][] envelopes) {
        int max = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));

        for (int[] env : envelopes) {
            int lo = 0, hi = max;
            while (lo < hi) {
                int mid = lo + (hi-lo)/2;

                if (dp[mid] < env[1]) lo = mid + 1;
                else hi = mid;
            }
            dp[lo] = env[1];
            if (lo == max) max++;
        }
        return max;
    }
}
