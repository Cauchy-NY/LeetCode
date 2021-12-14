package Easy;

import utils.TreeNode;

public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Integer.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
