package Medium;

public class Question55 {
    public boolean canJump(int[] nums) {
        int reach = 0, i = 0;
        for (; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i+nums[i]);
            if (reach >= nums.length-1)
                return true;
        }
        return false;
    }
}
