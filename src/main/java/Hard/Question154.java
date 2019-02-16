package Hard;

public class Question154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + ((right-left) >> 1);

            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[left])
                right = mid;
            else
                right -= 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2,2,2,0,1};
        int[] nums2 = new int[] {2,3,5,1,1};
        int[] nums3 = new int[] {3,3,1,3};
        System.out.println(new Question154().findMin(nums3));
    }
}
