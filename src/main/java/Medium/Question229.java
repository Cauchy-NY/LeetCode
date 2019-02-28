package Medium;

import java.util.*;

public class Question229 {
    /**
     * 思路：
     * 摩尔投票升级版，超过n/3的数最多只能有两个；先选出两个候选人A,B,遍历数组，
     * 如果投A（等于A），则A的票数++;如果投B，B的票数++；如果A,B都不投（即与A，B都不相等）
     * 那么检查此时是否AB中候选人的票数是否为0，如果为0,
     * 则成为新的候选人；如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均--；
     * 遍历结束后选出两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，
     * 找出两个候选人的具体票数
     */
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;

        for (int num: nums) {
            if (num == candidateA) { //投A
                countA++;
                continue;
            }
            if (num == candidateB) {// 投B
                countB++;
                continue;
            }

            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }

            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;

        for (int num: nums) {
            if (num == candidateA)
                countA++;
            else if (num == candidateB)
                countB++;
        }

        List<Integer> result = new ArrayList<>();

        if (countA > nums.length/3)
            result.add(candidateA);
        if (countB > nums.length/3)
            result.add(candidateB);

        return result;
    }

    public List<Integer> majorityElement_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int limit = Math.floorDiv(nums.length, 3);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);

            if (map.get(num) > limit)
                set.add(num);
        }
        return new ArrayList<>(set);
    }
}
