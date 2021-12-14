package Medium;

import utils.TreeNode;

import java.util.*;

public class Question199 {
    // 反向层序遍历取第一个
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0)
                    result.add(cur.val);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (cur.left != null)
                    queue.offer(cur.left);
            }
        }
        return result;
    }

    // most voted
    // Each depth of the tree only select one node.
    // View depth is current size of result list.
    public List<Integer> rightSideView_2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode cur, List<Integer> result, int currDepth) {
        if (cur == null)
            return;

        if (currDepth == result.size())
            result.add(cur.val);

        rightView(cur.right, result, currDepth + 1);
        rightView(cur.left, result, currDepth + 1);
    }
}
