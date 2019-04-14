package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2. 校园自行车分配
 *
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 *
 * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对  (worker, bike) ，并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
 *
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 *
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 *
 * 提示：
 *
 * 1. 0 <= workers[i][j], bikes[i][j] < 1000
 * 2. 所有工人和自行车的位置都不相同。
 * 3. 1 <= workers.length <= bikes.length <= 1000
 */
public class Question02_CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        int[] takeBy = new int[bikes.length];
        Arrays.fill(res, -1);
        Arrays.fill(takeBy, -1);

        List<Pair> list = new ArrayList<>(workers.length);
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);
                list.add(new Pair(i, j, distance));
            }
        }
        Collections.sort(list, (a, b) -> a.distance != b.distance ? a.distance - b.distance
                : a.worker != b.worker ? a.worker - b.worker : a.bike - b.bike);

        int count = 0;
        for (Pair pair: list) {
            if (count == res.length) break;
            if (res[pair.worker] != -1 || takeBy[pair.bike] != -1)
                continue;
            res[pair.worker] = pair.bike;
            takeBy[pair.bike] = pair.worker;
            count++;
        }
        return res;
    }

    class Pair {
        int worker;
        int bike;
        int distance;
        Pair(int worker, int bike, int distance) {
            this.worker = worker;
            this.bike = bike;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] workers = {{0,0}, {2,1}};
        int[][] bikes = {{1,2},{3,3}};
        new Question02_CampusBikes().assignBikes(workers, bikes);
    }
}
