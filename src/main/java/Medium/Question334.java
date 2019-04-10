package Medium;

public class Question334 {
    public boolean increasingTriplet(int[] nums) {
        // small、big 分别标记前两个数字，遍历的过程中，尽可能压低这两个数字
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) small = num;  // num < small
            else if (num <= big) big = num;  // small < num && num <= big
            else return true;  // num > big
        }
        return false;
    }

    // 这个居然能过？！
    public boolean increasingTriplet_2(int[] nums) {
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k] > nums[j])
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
