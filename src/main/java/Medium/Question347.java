package Medium;

import java.util.*;

public class Question347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList();
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Number> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
        map.forEach((key, val) -> queue.add(new Number(key, val)));

        int[]ret = new int[k];
        for (int i = 0; i < k; i++) {
            Number number = queue.poll();
            ret[i] = number.num;
        }
        return ret;
    }

    class Number {
        int num;
        int count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
