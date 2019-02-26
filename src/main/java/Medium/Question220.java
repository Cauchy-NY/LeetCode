package Medium;

import java.util.HashMap;
import java.util.Map;

public class Question220 {
    // dalao的神仙操作，滑动窗口+桶排序
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;

        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0 && (long) Math.abs(nums[i-j]-nums[i]) <= t)
                    return true;
                if (i+j < nums.length && (long) Math.abs(nums[i+j]-nums[i]) <= t)
                    return true;
            }
        }
        return false;
    }
}
