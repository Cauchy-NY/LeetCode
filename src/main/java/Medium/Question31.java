package Medium;

import java.util.Arrays;

public class Question31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int index = nums.length - 1;
        while (index > 0) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
        } else {
            for (int po = nums.length - 1; po > index - 1; po--) {
                if (nums[po] > nums[index - 1]) {
                    int tmp = nums[po];
                    nums[po] = nums[index - 1];
                    nums[index - 1] = tmp;
                    break;
                }
            }
            Arrays.sort(nums, index, nums.length);
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 3, 2});
    }
}
