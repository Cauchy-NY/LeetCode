package Easy;

public class Question53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, count = 0;
        for (int num: nums) {
            if (count < 0)
                count = num;
            else
                count += num;

            if (count > res)
                res = count;
        }
        return res;
    }
}
