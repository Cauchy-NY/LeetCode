package Hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question630 {
    // https://leetcode-cn.com/problems/course-schedule-iii/solution/gong-shui-san-xie-jing-dian-tan-xin-yun-ghii2/
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int sum = 0;
        for (int[] course: courses) {
            int cost = course[0];
            int ddl = course[1];
            sum += cost;
            queue.add(cost);
            if (sum > ddl) sum -= queue.poll();
        }
        return queue.size();
    }
}
