package Easy;

public class Question283 {
    // 一个意思，但代码更clean
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int insertPos = 0;
        for (int num: nums)
            if (num != 0)
                nums[insertPos++] = num;

        while (insertPos < nums.length)
            nums[insertPos++] = 0;
    }

    public void moveZeroes_2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int cur = 0;
        for (int i = 0; i < nums.length; i++, cur++) {
            while (nums[i] == 0 && i < nums.length-1)
                i++;
            nums[cur] = nums[i];
            nums[i] = 0;
        }

        for (int i = cur; i < nums.length; i++)
            nums[i] = 0;
    }
}
