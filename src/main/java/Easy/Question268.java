package Easy;

public class Question268 {
    // res初始化为n，遍历完之后一定有0~n的下标和除了缺失数之外的0~n的数
    // a = a ^ b ^ b，所以最后结果就是缺失数
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++)
            res = res ^ i ^ nums[i];
        return res;
    }

    public int missingNumber_2(int[] nums) {
        int target = nums.length * (nums.length+1) / 2, sum = 0;
        for (int num: nums)
            sum += num;
        return target - sum;
    }
}
