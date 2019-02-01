package Easy;

public class Question26 {
    public int removeDuplicates(int[] nums) {
        int len = 0, tag = Integer.MAX_VALUE;
        for(int num: nums) {
            if(tag != num) {
                tag = num;
                nums[len] = tag;
                len++;
            }
        }
        return len;
    }
}
