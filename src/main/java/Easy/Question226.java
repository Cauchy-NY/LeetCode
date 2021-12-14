package Easy;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question226 {
    // bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }

    //dfs
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null)
            return null;

        invertTree_2(root.left);
        invertTree_2(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
