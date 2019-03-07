package Medium;

import Design.NumArray2;

public class Question307 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray2 numArray2 = new NumArray2(nums);

        numArray2.sumRange(0, 2);  // -> 9
        numArray2.update(1, 2);
        numArray2.sumRange(0, 2);  // -> 8
    }
}
