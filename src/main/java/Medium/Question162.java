package Medium;

public class Question162 {
    // 题目规定了 nums[-1] = nums[n] = -∞ 这就好办了
    // 二分法，如果中间的是峰值直接返回，如果不是，那么两边较大的那一侧是存在峰值的。
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if ((mid == left || nums[mid] > nums[mid-1]) &&
                    (mid == right || nums[mid] > nums[mid+1]))
                return mid;
            if (mid == left || nums[mid] > nums[mid-1])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
