package Hard;

import java.util.*;

public class Question218 {
    // 第一步，我们用一个list来存储所有建筑物高度发生变化的点，要记录坐标和高度，
    // 然后先按坐标，再按高度排序，为了后续对堆的处理，
    // 这里需要规定建筑起点的高度记录为负数，终点记录为正数。
    // 第二步，初始化一个最大堆(堆顶始终保持着当前堆内最大值)，我们遍历上面的list，
    // 对每个元素，如果导致最大高度发生变化，那么这是一个轮廓改变点，需要加到结果集中。
    // 具体讲，对每个元素，如果是起点，需要把这个高度加入到堆内，把对之前做的负值再取负；
    // 如果是终点，证明这个建筑要在此消失了，需要把这个高度从堆内删除。做完上面的操作后，
    // 比较之前记录的轮廓高度与当前堆顶记录的最高高度，如果不同，就证明这个轮廓的高度发生变化了。
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

    // 按照里面的第一种实现，有问题，会超出空间限制
    // https://briangordon.github.io/2014/08/the-skyline-problem.html
    public List<int[]> getSkyline_2(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
            return res;

        int right = 0;
        for (int[] building: buildings) {
            if (building[1] > right)
                right = building[1];
        }

        int[] top = new int[right+2];  // 保证最后地平面的高度修正

        for (int[] building: buildings) {
           for (int i = building[0]; i <= building[1]; i++) {
               if (building[2] > top[i])
                   top[i] = building[2];
           }
        }

        int left = 0;
        while (top[left] == 0)
            left++;

        for (int i = left; i < top.length; i++) {
            if (i > 0 && top[i] != top[i-1]) {
                int[] point = new int[2];

                if (top[i] > top[i-1])
                    point[0] = i;
                else
                    point[0] = i-1;

                point[1] = top[i];
                res.add(point);
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[][] buildings = new int[][] {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };
        new Question218().getSkyline(buildings);
    }
}
