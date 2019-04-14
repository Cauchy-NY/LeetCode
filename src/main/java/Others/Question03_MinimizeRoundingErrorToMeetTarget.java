package Others;

/**
 * 3. 最小化舍入误差以满足目标
 *
 * 给定一系列价格 [p1,p2...,pn] 和一个目标 target，将每个价格 pi 舍入为 Roundi(pi) 以使得舍入数组 [Round1(p1),Round2(p2)...,Roundn(pn)] 之和达到给定的目标值 target。每次舍入操作 Roundi(pi) 可以是向下舍 Floor(pi) 也可以是向上入 Ceil(pi)。
 *
 * 如果舍入数组之和无论如何都无法达到目标值 target，就返回 -1。否则，以保留到小数点后三位的字符串格式返回最小的舍入误差，其定义为 Σ |Roundi(pi) - (pi)|（ i 从 1 到 n ）。
 *
 * 提示：
 *
 * 1. 1 <= prices.length <= 500
 * 2. 表示价格的每个字符串 prices[i] 都代表一个介于 0 和 1000 之间的实数，并且正好有 3 个小数位。
 * 3. target 介于 0 和 1000000 之间。
 */
public class Question03_MinimizeRoundingErrorToMeetTarget {
    // TLE
    private double min = Double.MAX_VALUE;

    public String minimizeError(String[] prices, int target) {
        double[] doublePrices = new double[prices.length];
        for (int i = 0; i < prices.length; i++)
            doublePrices[i] = Double.parseDouble(prices[i]);
        backtrack(doublePrices, target, doublePrices.length-1, 0.0);
        return min == Double.MAX_VALUE ? "-1" : String.format("%.3f", min);
    }

    public void backtrack(double[] prices, int target, int end, double round) {
        if (target < 0) return;
        if (end < 0) {
            if (target == 0) min = round < min ? round : min;
            return;
        }
        int floor = (int) Math.floor(prices[end]), ceil = (int) Math.ceil(prices[end]);
        backtrack(prices, target-floor, end-1, round+prices[end]-floor);
        backtrack(prices, target-ceil, end-1, round+ceil-prices[end]);
    }

    public static void main(String[] args) {
        String[] prices = {"0.700","2.800","4.900"};
        new Question03_MinimizeRoundingErrorToMeetTarget().minimizeError(prices, 8);
    }
}
