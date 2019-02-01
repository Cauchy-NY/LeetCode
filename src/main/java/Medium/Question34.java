package Medium;

public class Question34 {
    // 注释掉的代码玄学TLE
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = lowerBound(nums, 0, nums.length, target);
        ans[1] = upperBound(nums, 0, nums.length, target) - 1;
        if(ans[0] > ans[1]) ans[0] = ans[1] = -1;
        return ans;
    }

    private int upperBound(int[] nums, int l, int r, int target) {
        while(l < r) { // [l, r)
            int m = l + (r - l) / 2;
            if(target >= nums[m]) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int lowerBound(int[] nums, int l, int r, int target) {
        while(l < r) { // [l, r)
            int m = l + (r - l) / 2;
            if(target > nums[m]) l = m + 1;
            else r = m;
        }
        return l;
    }
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[] {-1, -1};
//        if (nums.length == 0)
//            return result;
//
//        int low = 0, high = nums.length-1;
//        // find the left bound
//        while (low < high) {
//            int mid = (low + high) / 2;
//            if (nums[mid] < target)
//                low = mid + 1;
//            else
//                high = mid;
//        }
//        if (nums[high] != target)
//            return result;
//        else
//            result[0] = low;
//        // find the right bound
//        high =  nums.length-1;
//        while (low < high) {
//            int mid = (low + high) / 2;
//            if (nums[mid] > target)
//                high = mid - 1;
//            else
//                low = mid;
//        }
//        result[1] = high;
//        return result;
//    }
}
