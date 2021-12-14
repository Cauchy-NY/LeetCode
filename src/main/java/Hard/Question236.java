package Hard;

import utils.TreeNode;

import java.util.*;

public class Question236 {
    // 简洁版
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor_2(root.left, p, q);
        TreeNode right = lowestCommonAncestor_2(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;

        return null;
    }

    // 遍历树，找到通往p和q的路径，再找两条路径的重合点重合点即为最近公共祖先
    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
