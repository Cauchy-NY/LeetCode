package Easy;

public class Question169 {
    // 定义众数为在数组中出现次数大于⌊n/2⌋的数
    public int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i])
                count++;
            else {
                count--;
                if (count == 0)
                    res = nums[i + 1];
            }
        }
        return res;
    }
}
