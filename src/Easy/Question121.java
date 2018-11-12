package Easy;

public class Question121 {
    /**
     * 保存一个当前位置以前的，最小的售价，
     * 注意题目要求就只是买卖一次，所以在最低价时买，当前位置处比较
     * */
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length < 2)
            return result;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }

//    /**
//     * discuss vote No.1
//     * Kadane算法思想——最大子片段中不可能包含求和值为负的前缀
//     * 同理，最大的股票差值出现的时间段前期不可能有股价下跌
//     */
//    public int maxProfit(int[] prices) {
//        int maxCur = 0, maxSoFar = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
//            maxSoFar = Math.max(maxCur, maxSoFar);
//        }
//        return maxSoFar;
//    }

//    // 速度太慢
//    public int maxProfit(int[] prices) {
//        int res = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int tmpMax = prices[i];
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[j] > tmpMax)
//                    tmpMax = prices[j];
//                if (tmpMax-prices[i] > res)
//                    res = tmpMax-prices[i];
//            }
//        }
//        return res;
//    }
}
