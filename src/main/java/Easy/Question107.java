package Easy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null)
            put(res, 1, root);
        Collections.reverse(res);
        return res;
    }

    private void put(List<List<Integer>> res, int level, TreeNode node) {
        if (level > res.size()) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }

        res.get(level - 1).add(node.val);

        if (node.left != null)
            put(res, level+1, node.left);
        if (node.right != null)
            put(res, level+1, node.right);
    }
}
