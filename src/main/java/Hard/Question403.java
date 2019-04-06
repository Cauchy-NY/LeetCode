package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question403 {
    // 不计算距离，把思路局限在dp里面
    // 直接从当前石头进行搜索，如果能到目标直接返回
    public boolean canCross(int[] stones) {
        if (stones.length == 0)
            return true;

        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++)
            map.put(stones[i], new HashSet<>());

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;

                if (reach == stones[stones.length - 1])
                    return true;

                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }

    // TLE
    public boolean canCross_2(int[] stones) {
        if (stones == null) return false;
        if (stones.length == 1) return true;
        if (stones[1]-stones[0] > 1) return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < stones.length; i++)
            map.put(stones[i], new HashSet<>());

        map.get(stones[1]).add(1);
        for (int i = 2; i < stones.length; i++) {
            Set<Integer> set = map.get(stones[i]);
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = map.get(stones[j]);
                if (!preSet.isEmpty()) {
                    int distance = stones[i] - stones[j];
                    if (preSet.contains(distance)
                            || preSet.contains(distance-1)
                            || preSet.contains(distance+1))
                        set.add(distance);
                }
            }
        }

        return !map.get(stones[stones.length-1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,6,10,15,16,21};
        new Question403().canCross(stones);
    }
}
