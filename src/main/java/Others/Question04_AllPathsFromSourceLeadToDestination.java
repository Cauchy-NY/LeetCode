package Others;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定有向图的边 edges，以及该图的始点 source 和目标终点 destination，确定从始点 source 出发的所有路径是否最终结束于目标终点 destination，即：
 *
 *   1.从始点 source 到目标终点 destination 存在至少一条路径
 *   2.如果存在从始点 source 到没有出边的节点的路径，则该节点就是路径终点。
 *   3.从始点source到目标终点 destination 可能路径数是有限数字
 * 当从始点 source 出发的所有路径都可以到达目标终点 destination 时返回 true，否则返回 false。
 *
 * 提示：
 *
 * 1. 给定的图中可能带有自环和平行边。
 * 2. 图中的节点数 n 介于 1 和 10000 之间。
 * 3. 图中的边数在 0 到 10000 之间。
 * 4. 0 <= edges.length <= 10000
 * 5. edges[i].length == 2
 * 6. 0 <= source <= n - 1
 * 7. 0 <= destination <= n - 1
 */
public class Question04_AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] edge : edges)
            map.computeIfAbsent(edge[0], k -> new PriorityQueue()).add(edge[1]);
        return false;
    }
}
