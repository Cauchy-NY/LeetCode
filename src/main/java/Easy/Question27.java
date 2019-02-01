package Easy;

public class Question27 {
    public int removeElement(int[] nums, int val) {
        int tag = nums.length-1, len = 0;
        while(len <= tag) {
            if(nums[len] == val) {
                while(nums[tag] == val && tag != len)
                    tag--;
                if(tag == len)
                    break;
                nums[len] = nums[tag];
                nums[tag] = val;
            }
            len++;
        }
        return len;
    }
}
