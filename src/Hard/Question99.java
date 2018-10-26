package Hard;

import util.TreeNode;

public class Question99 {
    // 核心想法：正确的二叉搜索树一定中序遍历一定是顺序排列的
    // 找出乱序的两个节点即可
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        traverse(root.right);
    }
}
