package Hard;

import javafx.util.Pair;

import java.util.*;

public class Question786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<Double> minHeap = new PriorityQueue<>();
        Map<Double, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double factor = (double) arr[i] / arr[j];
                map.put(factor, new Pair<>(arr[i], arr[j]));
                minHeap.add(factor);
            }
        }
        double minK = 0;
        for (int i = 0; i < k; i++) {
            minK = minHeap.poll();
        }
        Pair<Integer, Integer> res = map.get(minK);
        return new int[]{res.getKey(), res.getValue()};
    }

    public static void main(String[] args) {
        Question786 question = new Question786();
        int[] res = question.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        System.out.println(res[0] + ", " + res[1]);

        res = question.kthSmallestPrimeFraction(new int[]{1, 7}, 1);
        System.out.println(res[0] + ", " + res[1]);
    }
}
