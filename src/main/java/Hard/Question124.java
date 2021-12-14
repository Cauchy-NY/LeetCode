package Hard;

import utils.TreeNode;

public class Question124 {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        backtrack(root);
        return maxPathSum;
    }

    private int backtrack(TreeNode node) {
        int leftMax = node.left == null ? Integer.MIN_VALUE : backtrack(node.left);
        int rightMax = node.left == null ? Integer.MIN_VALUE : backtrack(node.right);

        int tmp = node.val;
        if (leftMax > 0)
            tmp += leftMax;
        if (rightMax > 0)
            tmp += rightMax;

        maxPathSum = Integer.max(maxPathSum, tmp);

        return node.val + Integer.max(Integer.max(0, leftMax), rightMax);
    }
}
