package Medium;

public class Question16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0, len = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(Math.abs(nums[i]+nums[j]+nums[k] - target) < len) {
                        result = nums[i]+nums[j]+nums[k];
                        len = Math.abs(result - target);
                    }
                }
            }
        }
        return result;
    }
}
