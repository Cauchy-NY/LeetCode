package Hard;

import Design.SummaryRanges;
import util.Interval;

import java.util.List;

public class Question352 {
    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(7);
        List<Interval> param_1 = obj.getIntervals();
        obj.addNum(2);
        List<Interval> param_2 = obj.getIntervals();
        obj.addNum(6);
        List<Interval> param_3 = obj.getIntervals();
    }
}
