package Medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class Question378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = heap.poll();
            if (now[2] != matrix.length - 1) {
                heap.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return heap.poll()[0];
    }

    public static void main(String[] args) {
        Question378 question = new Question378();
        System.out.println(question.kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));

        System.out.println(question.kthSmallest(new int[][]{
                {-5}
        }, 1));
    }
}
