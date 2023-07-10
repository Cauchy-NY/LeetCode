package dp;

public class DP15_Question121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }

    public static void main(String[] args) {
        DP15_Question121 question = new DP15_Question121();
        System.out.println(question.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(question.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
