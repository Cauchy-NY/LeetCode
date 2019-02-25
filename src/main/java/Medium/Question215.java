package Medium;

public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        int ans, pos = nums.length-k;
        while ((ans=partition(nums, left, right)) != pos)
            if (ans < pos)
                left = ans + 1;
            else
                right = ans - 1;
        return nums[nums.length-k];
    }

    private int partition(int[] nums, int left, int right) {
        int val = nums[right];
        for (int i = left; i < right; i++)
            if (nums[i] < val)
                swap(nums, left++, i);
        swap(nums, right, left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
