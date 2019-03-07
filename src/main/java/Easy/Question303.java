package Easy;

import Design.NumArray;

public class Question303 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        numArray.sumRange(0, 2); // -> 1
        numArray.sumRange(2, 5); // -> -1
        numArray.sumRange(0, 5); // -> -3
    }
}
