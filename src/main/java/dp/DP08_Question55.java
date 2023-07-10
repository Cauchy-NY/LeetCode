package dp;

public class DP08_Question55 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == nums.length-1 || max >= nums.length) {
                return true;
            }
            if (max == i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DP08_Question55 question = new DP08_Question55();
        System.out.println(question.canJump(new int[]{0}));
        System.out.println(question.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(question.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
