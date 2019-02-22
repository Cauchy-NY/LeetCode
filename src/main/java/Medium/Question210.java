package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        if (numCourses <= 0 || prerequisites == null)
            return new int[0];
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }

        int[][] matrix = new int[numCourses][numCourses];  // i -> j
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++;  // duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[count++] = course;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
