package Medium;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

public class Question56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;
        List<Interval> res = new ArrayList<>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval: intervals) {
            if (interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
            else
                end = Math.max(end, interval.end);
        }
        res.add(new Interval(start, end));
        return res;
    }
}
