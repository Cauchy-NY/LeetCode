package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        int levelCount = 1, nextCount = 0, cur = 0;
        queue.add(root);

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            cur++;

            if (!node.children.isEmpty()) {
                nextCount += node.children.size();
                node.children.forEach(child -> queue.add(child));
            }
            level.add(node.val);

            if (cur == levelCount) {
                levelCount = nextCount;
                nextCount = 0;
                cur = 0;
                ret.add(level);
                level = new ArrayList<>();
            }
        }
        return ret;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
