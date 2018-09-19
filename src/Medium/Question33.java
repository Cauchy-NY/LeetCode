package Medium;

public class Question33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        // find the min, low == high is the min index
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (low+high) / 2;
            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
        }
        int offset = low;
        // binary find the target
        low = 0; high = nums.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int realMid = (mid + offset) % nums.length;
            if(nums[realMid] == target)
                return realMid;
            else if (nums[realMid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}
