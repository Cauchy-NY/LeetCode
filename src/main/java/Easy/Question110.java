package Easy;

import util.TreeNode;

public class Question110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Integer.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
