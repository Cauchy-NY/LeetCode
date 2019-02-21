package Hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question207 {
    // DFS Topological Sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null)
            return false;
        if (prerequisites.length == 0)
            return true;

        boolean[] visited = new boolean[numCourses];
        boolean[] onVisiting = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prerequisites, visited, onVisiting, stack))
                return false;
        }
        return true;
    }

    private boolean dfs(int i, int[][] prerequisites, boolean[] visited, boolean[] onVisiting, Stack<Integer> stack) {
        if (visited[i])
            return true;

        visited[i] = true;
        onVisiting[i] = true;

        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == i) {
                if (onVisiting[prerequisite[1]])
                    return false;
                if (!visited[prerequisite[1]])
                    if (!dfs(prerequisite[1], prerequisites, visited, onVisiting, stack))
                        return false;
            }
        }

        onVisiting[i] = false;
        stack.push(i);

        return true;
    }

    // BFS Topological Sort
    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null)
            return false;
        if (prerequisites.length == 0)
            return true;

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
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
