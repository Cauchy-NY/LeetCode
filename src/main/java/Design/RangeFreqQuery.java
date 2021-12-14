package Design;

import javafx.util.Pair;

import java.util.*;

public class RangeFreqQuery {

    private int size;
    private Map<Integer, List<Integer>> map;
    private Map<Pair<Pair<Integer, Integer>, Integer>, Integer> cache;

    public RangeFreqQuery(int[] arr) {
        size = arr.length;
        map = new HashMap<>();
        cache = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (left > right || left < 0 || right >= size)
            return 0;
        if (!map.containsKey(value))
            return 0;

        Pair<Pair<Integer, Integer>, Integer> queryReq = new Pair(new Pair(left, right), value);
        if (cache.containsKey(queryReq))
            return cache.get(queryReq);

        List<Integer> idxList = map.get(value);
        int count = 0;
        for (int idx : idxList) {
            if (left > idx) continue;
            if (idx <= right)
                count++;
            else
                break;
        }
        cache.put(queryReq, count);
        return count;
    }
}

// Treemap great answer
//public class RangeFreqQuery {
//    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
//    public RangeFreqQuery(int[] arr) {
//        for(int i = 0; i < arr.length;i++){
//            map.putIfAbsent(arr[i], new TreeMap<>());
//            map.get(arr[i]).put(i, map.get(arr[i]).size());
//        }
//
//    }
//
//    public int query(int left, int right, int value) {
//        if(!map.containsKey(value)) return 0;
//        TreeMap<Integer, Integer> nums = map.get(value);
//        Integer a = nums.ceilingKey(left), b = nums.floorKey(right);
//        if(a == null || b == null) return 0;
//        return nums.get(b) - nums.get(a) +1;
//    }
//}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */