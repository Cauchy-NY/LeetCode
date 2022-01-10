package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int remain = capacity;
        for (int[] trip : trips) {
            int location = trip[1];
            while (!heap.isEmpty() && heap.peek()[2] <= location) {
                int[] finishedTrip = heap.poll();
                remain += finishedTrip[0];
            }
            if (remain >= trip[0]) {
                remain -= trip[0];
                heap.offer(trip);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question1094 question = new Question1094();
        System.out.println(question.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        }, 4));

        System.out.println(question.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        }, 5));
        System.out.println(question.carPooling(new int[][]{
                {2, 1, 5},
                {3, 5, 7}
        }, 3));
        System.out.println(question.carPooling(new int[][]{
                {3, 2, 7},
                {3, 7, 9},
                {8, 3, 9}
        }, 11));
    }
}
