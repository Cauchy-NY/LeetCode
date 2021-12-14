package Medium;

import utils.TreeNode;

public class Question222 {
    // 1 << h == 1(root)+左子树节点数（此时左子树为完美二叉树）
    // 1 << h-1 == 1(root)+右子树节点数（此时右子树为完美二叉树）
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 : height(root.right) == h-1
                ? (1 << h) + countNodes(root.right)
                : (1 << h-1) + countNodes(root.left);
    }
    // root是0层
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes_2(TreeNode root) {
        return root == null ? 0 : 1 + countNodes_2(root.left) + countNodes_2(root.right);
    }

    public int countNodes_3(TreeNode root) {
        if (root == null)
            return 0;

        int leftmost = 0, rightmost = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            leftmost++;
            left = left.left;
        }
        while (right != null) {
            rightmost++;
            right = right.right;
        }

        if (leftmost == rightmost)
            return (1 << leftmost) - 1;

        return 1 + countNodes_3(root.left) + countNodes_3(root.right);
    }
}
