package Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null)
            put(res, 1, root);
        return res;
    }

    private void put(List<List<Integer>> res, int level, TreeNode node) {
        if (level > res.size()) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }

        if (level % 2 != 0)
            res.get(level - 1).add(node.val);
        else
            res.get(level - 1).add(0, node.val);

        if (node.left != null)
            put(res, level + 1, node.left);
        if (node.right != null)
            put(res, level + 1, node.right);
    }
}
