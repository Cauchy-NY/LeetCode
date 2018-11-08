package Easy;

import org.omg.PortableInterceptor.INACTIVE;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return false;

        backtrack(res, root, 0);

        for (int i: res) {
            if (i == sum)
                return true;
        }
        return false;
    }

    private void backtrack(List<Integer> res, TreeNode node, int sum) {
        if (isLeaf(node))
            res.add(sum+node.val);
        else {
            if (node.left != null)
                backtrack(res, node.left, sum+node.val);
            if (node.right != null)
                backtrack(res, node.right, sum+node.val);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
