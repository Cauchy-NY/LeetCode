package Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question114 {

    private TreeNode next = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    public void flatten_2(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            TreeNode predecessor = cur.left;
            while (predecessor != null) {
                if (predecessor.right == null) break;
                predecessor = predecessor.right;
            }
            predecessor.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
        }
    }

//    // 没太能看懂这道题意思，简单的以为按大小展开
//    public void flatten(TreeNode root) {
//        if (root == null)
//            return;
//        List<TreeNode> res = new ArrayList<>();
//        backtrack(res, root);
//        res.sort((a, b) -> a.val - b.val);
//        for (int i = 0; i < res.size()-1; i++) {
//            res.get(i).left = null;
//            res.get(i).right = res.get(i+1);
//        }
//        res.get(res.size()-1).right = null;
//    }
//
//    private void backtrack(List<TreeNode> res, TreeNode node) {
//        if (node == null)
//            return;
//        else {
//            res.add(node);
//            backtrack(res, node.left);
//            backtrack(res, node.right);
//        }
//    }
}
