package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question207 {

    private final List<List<Integer>> edges = new ArrayList<>();
    private int[] visited;
    private boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int course) {
        visited[course] = 1;  // 搜索中
        for (int after : edges.get(course)) {
            if (visited[after] == 0) {  // 未搜索
                dfs(after);
                if (!valid) {
                    return;
                }
            } else if (visited[after] == 1) {
                valid = false;
                return;
            }
        }
        visited[course] = 2;  // 搜索完
    }

    private final List<List<Integer>> edges2 = new ArrayList<>();
    private int[] indeg;

    public boolean canFinishWithBFS(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges2.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges2.get(prerequisite[1]).add(prerequisite[0]);
            indeg[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int prev = queue.poll();
            for (int after : edges2.get(prev)) {
                --indeg[after];
                if (indeg[after] == 0) {
                    queue.offer(after);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        Question207 question = new Question207();
        System.out.println(question.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(question.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(question.canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
    }
}
