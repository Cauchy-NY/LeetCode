package Medium;

import Design.RangeFreqQuery;

public class Question2080 {
    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery.query(1, 2, 4)); // return 1. The value 4 occurs 1 time in the subarray [33, 4]
        System.out.println(rangeFreqQuery.query(0, 11, 33)); // return 2. The value 33 occurs 2 times in the whole array.
        System.out.println(rangeFreqQuery.query(0, 11, 33));
    }
}
