package dp;

public class DP13_Question1567 {

    /**
     * positive_len: 以该数据为结尾的子数组的最大正长度
     * negative_len：以该数据为结尾的子数组的最大负长度
     * elements      :   9    5    8    2    -6    4    -3    0    2    -5    15    10    -7    9    -2
     * positive_len  :   1    2    3    4     0    1     7    0    1     0     1     2     5    6     5
     * negative_len  :   0    0    0    0     5    6     2    0    0     2     3     4     3    4     7
     */
    public int getMaxLen(int[] nums) {
        int positive = 0, negative = 0;    // length of positive and negative results
        int ans = 0;
        for (int x : nums) {
            if (x == 0) {
                positive = 0;
                negative = 0;
            } else if (x > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            ans = Math.max(ans, positive);
        }
        return ans;
    }

    public static void main(String[] args) {
        DP13_Question1567 question = new DP13_Question1567();
        System.out.println(question.getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(question.getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(question.getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }
}
