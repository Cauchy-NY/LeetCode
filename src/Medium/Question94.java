package Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        if (node.left != null)
            inOrder(node.left, res);
        res.add(node.val);
        if (node.right != null)
            inOrder(node.right, res);
    }
}
