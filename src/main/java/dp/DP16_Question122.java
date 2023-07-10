package dp;

public class DP16_Question122 {
    // greedy
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }

    // lack dp solution

    public static void main(String[] args) {
        DP16_Question122 question = new DP16_Question122();
        System.out.println(question.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(question.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
