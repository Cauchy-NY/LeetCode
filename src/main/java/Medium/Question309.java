package Medium;

public class Question309 {
    // 每天的动作一定是三个操作之一 buy、sell、rest，buy之后才能sell，sell完之后一定要rest
    // buy[i] = max(sell[i-2]-price, buy[i-1])
    // sell[i] = max(buy[i-1]+price, sell[i-1])
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price: prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
