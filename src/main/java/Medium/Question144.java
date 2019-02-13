package Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question144 {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        backtrack(list, root);
        return preorderWithStack(root);
    }

    // 迭代解
    private List<Integer> preorderWithStack(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<>();

        while (node != null) {
            list.add(node.val);

            if (node.right != null)
                rights.push(node.right);

            node = node.left;

            if (node == null && !rights.isEmpty())
                node = rights.pop();
        }
        return list;
    }

    // 递归解
    private void backtrack(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        list.add(root.val);
        backtrack(list, root.left);
        backtrack(list, root.right);
    }
}
