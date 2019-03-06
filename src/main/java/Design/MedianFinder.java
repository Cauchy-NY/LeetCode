package Design;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> small;
    private Queue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.small = new PriorityQueue<>((a, b) -> b - a);
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return large.size() == small.size()
                ? (large.peek() + small.peek()) / 2.0
                : large.peek();
    }
}
