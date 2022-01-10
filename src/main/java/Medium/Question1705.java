package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question1705 {
    // TLE
    public int eatenApples(int[] apples, int[] days) {
        int ate = 0, date = 0;
        int total = Arrays.stream(apples).sum();
        while (total != 0) {
            int maxLen = Math.min(date, apples.length - 1);
            int firstOut = Integer.MAX_VALUE, chosen = -1;
            for (int i = 0; i <= maxLen; i++) {
                if (apples[i] == 0) {
                    continue;
                }
                if (i + days[i] <= date) {
                    total -= apples[i];
                    apples[i] = 0;
                    continue;
                }
                if (i + days[i] < firstOut) {
                    firstOut = i + days[i];
                    chosen = i;
                }
            }
            if (chosen != -1) {
                apples[chosen]--;
                total--;
                ate++;
            }
            date++;
        }
        return ate;
    }

    public int eatenApples2(int[] apples, int[] days) {
        int ans = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = apples.length;
        int i = 0;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            int rottenDay = i + days[i];
            int count = apples[i];
            if (count > 0) {
                pq.offer(new int[]{rottenDay, count});
            }
            if (!pq.isEmpty()) {
                int[] arr = pq.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    pq.poll();
                }
                ans++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] arr = pq.poll();
            int curr = Math.min(arr[0] - i, arr[1]);
            ans += curr;
            i += curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question1705 question = new Question1705();
        System.out.println(question.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(question.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    }
}
