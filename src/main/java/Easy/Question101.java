package Easy;

import util.TreeNode;

import java.util.Stack;

public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricEqual(root.left, root.right);
    }

    private boolean isSymmetricEqual(TreeNode left, TreeNode right) {
        if (right == null || left == null)
            return right == left;
        if (right.val != left.val)
            return false;
        return isSymmetricEqual(left.left, right.right) && isSymmetricEqual(left.right, right.left);
    }

//    // 用栈代替递归
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)
//            return true;
//        // init
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode left, right;
//        if (root.left != null) {
//            if (root.right == null)
//                return false;
//            stack.push(root.left);
//            stack.push(root.right);
//        }
//        else if (root.right != null)
//            return false;
//
//        while (!stack.empty()) {
//            if (stack.size() % 2 != 0)
//                return false;
//            right = stack.pop();
//            left = stack.pop();
//            if(right.val != left.val)
//                return false;
//
//            if (left.left != null) {
//                if (right.right == null)
//                    return false;
//                stack.push(left.left);
//                stack.push(right.right);
//            }
//            else if (right.right != null)
//                return false;
//
//            if (left.right != null) {
//                if (right.left == null)
//                    return false;
//                stack.push(left.right);
//                stack.push(right.left);
//            }
//            else if (right.left != null)
//                return false;
//
//        }
//        return true;
//    }
}
