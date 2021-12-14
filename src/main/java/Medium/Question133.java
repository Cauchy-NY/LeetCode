package Medium;

import utils.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

public class Question133 {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (map.containsKey(node.label))
            return map.get(node.label);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}
