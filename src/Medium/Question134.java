package Medium;

public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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
