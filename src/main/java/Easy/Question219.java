package Easy;

import java.util.*;

public class Question219 {
    // 存在 nums[i] = nums[j] 且 j-i <= k 即返回true
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i-k-1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Map<Integer, Integer> begin = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (begin.containsKey(nums[i])) {
                if (i - begin.get(nums[i]) <= k)
                    return true;
                else
                    begin.put(nums[i], i);
            } else {
                begin.put(nums[i], i);
            }
        }
        return false;
    }
}
