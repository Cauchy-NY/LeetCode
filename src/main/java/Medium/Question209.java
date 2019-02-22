package Medium;

public class Question209 {
    // 滑动窗口，时间复杂度-O(n)，空间复杂度-O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0, r = 0, count = 0;
        int minLen = nums.length+1;

        while (r < nums.length) {
            count += nums[r++];

            while (count >= s) {
                minLen = Math.min(minLen, r - l);
                count -= nums[l++];
            }
        }

        return minLen == nums.length+1 ? 0 : minLen;
    }

    // 二分法，时间复杂度-O(nlogn)，空间复杂度-O(1)
    // 初始估计符合条件的长度为len/2，不满足则调高，满足调低，更新min
    public int minSubArrayLen_2(int s, int[] nums) {
        int l = 1, r = nums.length, min = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (windowExist(mid, nums, s)) {
                r = mid - 1;
                min = mid;
            } else
                l = mid + 1;
        }
        return min;
    }


    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }
}
