package Medium;

public class Question80 {
    public int removeDuplicates(int[] nums) {
        int len = 0, tag = Integer.MAX_VALUE, count = 0;
        for (int num: nums) {
            if (num != tag) {
                tag = num;
                nums[len++] = tag;
                count = 1;
            }
            else if (count == 1) {
                nums[len++] = tag;
                count++;
            }
            else
                count++;
        }
        return len;
    }
}
