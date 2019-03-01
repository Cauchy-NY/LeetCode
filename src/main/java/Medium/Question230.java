package Medium;

import util.TreeNode;

import java.util.Stack;

public class Question230 {
    // dfs 顺序找第k个，迭代
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) return node.val;
            // 找当前值的下一个值，二叉搜索树顺序遍历时经常用到
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
    }

    public int kthSmallest_2(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k == count+1)
            return root.val;

        if (k < count+1)
            return kthSmallest_2(root.left, k);
        else
            return kthSmallest_2(root.right, k-1-count); // 1 is counted as current node

    }

    private int countNodes(TreeNode n) {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    // dfs 顺序找第k个，递归
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest_3(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}
