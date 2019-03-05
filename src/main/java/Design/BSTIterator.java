package Design;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 非递归写法
public class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

//// 递归写法
//public class BSTIterator {
//
//    private Queue<Integer> queue = new LinkedList<>();
//
//    public BSTIterator(TreeNode root) {
//        inOrder(root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return queue.poll();
//    }
//
//    private void inOrder(TreeNode root){
//        if(root == null)
//            return;
//        inOrder(root.left);
//        queue.add(root.val);
//        inOrder(root.right);
//    }
//}
