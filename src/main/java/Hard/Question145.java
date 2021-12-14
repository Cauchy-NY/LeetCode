package Hard;

import utils.TreeNode;

import java.util.*;

public class Question145 {
    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        backtrack(list, root);
        return postorderWithStack(root);
    }

    // 迭代解
    private List<Integer> postorderWithStack(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> lefts = new Stack<>();

        while (node != null) {
            list.addFirst(node.val);

            if (node.left != null)
                lefts.push(node.left);

            node = node.right;

            if (node == null && !lefts.isEmpty())
                node = lefts.pop();
        }
        return list;
    }

    // 递归解
    private void backtrack(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        backtrack(list, root.left);
        backtrack(list, root.right);
        list.add(root.val);
    }
}
