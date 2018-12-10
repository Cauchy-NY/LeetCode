package Hard;

import java.util.HashMap;
import java.util.Map;

public class Question128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num-1) ? map.get(num-1) : 0;
                int right = map.containsKey(num+1) ? map.get(num+1) : 0;
                int sum = left+right+1;

                map.put(num, sum);

                res = Integer.max(res, sum);

                map.put(num-left, sum);
                map.put(num+right, sum);
            }
        }
        return res;
    }
}
