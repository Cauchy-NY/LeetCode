package Hard;

import utils.TreeNode;

public class Question968 {
    public int minCameraCover(TreeNode root) {
        int[] ret = dfs(root);
        return ret[1];
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};

        int[] leftArray = dfs(node.left);
        int[] rightArray = dfs(node.right);

        int[] ret = new int[3];
        ret[0] = leftArray[2] + rightArray[2] + 1;
        ret[1] = Math.min(ret[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        ret[2] = Math.min(ret[0], leftArray[1] + rightArray[1]);
        return ret;
    }
}
