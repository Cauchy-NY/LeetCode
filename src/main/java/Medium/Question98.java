package Medium;

import utils.TreeNode;

public class Question98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && findMax(root.left) >= root.val)
            return false;
        if (root.right != null && findMin(root.right) <= root.val)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.val;
    }

    private int findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node.val;
    }
}
