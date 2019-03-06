package Hard;

import Design.MedianFinder;

public class Question295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();  // -> 1.5
        medianFinder.addNum(3);
        medianFinder.findMedian();  // -> 2
    }
}
