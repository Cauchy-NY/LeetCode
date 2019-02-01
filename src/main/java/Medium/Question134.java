package Medium;

public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * 思路: 累加在每个位置的left += gas[i] - cost[i], 就是在每个位置剩余的油量,
         * 如果left一直大于0, 就可以一直走下取. 如果left小于0了, 那么就从下一个位置重新开始计数,
         * 并且将之前欠下的多少记录下来, 如果最终遍历完数组剩下的燃料足以弥补之前不够的, 那么就可以到达,
         * 并返回最后一次开始的位置.否则就返回-1.
         * 证明这种方法的正确性: 
         * 1. 如果从头开始, 每次累计剩下的油量都为整数, 那么没有问题, 他可以从头开到结束.
         * 2. 如果到中间的某个位置, 剩余的油量为负了, 那么说明之前累积剩下的油量不够从这一站到下一站了.
         * 那么就从下一站从新开始计数. 为什么是下一站, 而不是之前的某站呢?
         * 因为第一站剩余的油量肯定是大于等于0的, 然而到当前一站油量变负了,
         * 说明从第一站之后开始的话到当前油量只会更少而不会增加. 也就是说从第一站之后,
         * 当前站之前的某站出发到当前站剩余的油量是不可能大于0的.
         * 所以只能从下一站重新出发开始计算从下一站开始剩余的油量, 并且把之前欠下的油量也累加起来,
         * 看到最后剩余的油量是不是大于欠下的油量.
        */
        int debt = 0, remain = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }
        return remain + debt < 0 ? -1 : start;

//        有点慢，基本上是O(n^2)
//        int[] minus = new int[gas.length];
//        for (int i = 0; i < gas.length; i++)
//            minus[i] = gas[i] - cost[i];
//
//        for (int i = 0; i < minus.length; i++) {
//            if (minus[i] < 0)
//                continue;
//
//            int total = 0;
//            int index = i;
//            boolean find = true;
//            for (int j = 0; j < minus.length; j++) {
//                total += minus[index];
//                index = (index+1) % minus.length;
//
//                if (total < 0) {
//                    find = false;
//                    break;
//                }
//            }
//
//            if (find)
//                return i;
//        }
//
//        return -1;
    }
}
