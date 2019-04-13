package Design;

import util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges {

    private TreeMap<Integer, Interval> tree;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;

        Integer lowerKey = tree.lowerKey(val);
        Integer higherKey = tree.higherKey(val);

        if(lowerKey != null && higherKey != null && tree.get(lowerKey).end + 1 == val && higherKey == val + 1) {
            tree.get(lowerKey).end = tree.get(higherKey).end;
            tree.remove(higherKey);
        } else if(lowerKey != null && tree.get(lowerKey).end + 1 >= val) {
            tree.get(lowerKey).end = Math.max(tree.get(lowerKey).end, val);
        } else if(higherKey != null && higherKey == val + 1) {
            tree.put(val, new Interval(val, tree.get(higherKey).end));
            tree.remove(higherKey);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}
