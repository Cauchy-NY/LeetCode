package Easy;

public class Question136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Question136().singleNumber(new int[] {1, 1, 3, 2, 3}));
    }
}
