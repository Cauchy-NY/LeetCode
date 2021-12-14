package Hard;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class Question57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (newInterval == null)
            return intervals;
        if (intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }
        int start = 0, end = 0;
        boolean isOverLapping = false, isAdd = false;
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start)
                res.add(interval);
            else {
                if (interval.start > newInterval.end) {
                    res.add(interval);
                    if (!isAdd) {
                        res.add(newInterval);
                        isAdd = true;
                    }
                }
                else {
                    start = Math.min(interval.start, newInterval.start);
                    isOverLapping = true;
                    isAdd = true;
                    break;
                }
            }
        }
        if (!isAdd)
            res.add(newInterval);
        if (isOverLapping) {
            for (int i = intervals.size() - 1; i >= 0; i--) {
                if (newInterval.end < intervals.get(i).start)
                    res.add(intervals.get(i));
                else {
                    end = Math.max(intervals.get(i).end, newInterval.end);
                    break;
                }
            }
            res.add(new Interval(start, end));
        }
        res.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        return res;
    }
}
