package Design;

public class NumArray {
    private final int[] nums;

    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        return nums[j] - nums[i - 1];
    }
}

//public class NumArray {
//
//    private final int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int idx = i; idx <= j; idx++)
//            sum += nums[idx];
//        return sum;
//    }
//}
