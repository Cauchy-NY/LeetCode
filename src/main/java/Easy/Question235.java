package Easy;

import utils.TreeNode;

public class Question235 {
    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if ((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
        else if (root.val - p.val < 0)
            return lowestCommonAncestor(root.right, p, q);
        else
            return lowestCommonAncestor(root.left, p, q);
    }

    // 迭代
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
