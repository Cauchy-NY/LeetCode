package Medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Question337 {
    // 抢不抢这个节点只需要一个长度为2的局部数组来记录
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    // 记忆化搜索
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob_2(TreeNode root) {
        if (root == null) return 0;

        if (map.containsKey(root))
            return map.get(root);

        int val = 0;

        if (root.left != null)
            val += rob_2(root.left.left) + rob_2(root.left.right);
        if (root.right != null)
            val += rob_2(root.right.left) + rob_2(root.right.right);

        val = Math.max(val + root.val, rob_2(root.left) + rob_2(root.right));
        map.put(root, val);

        return val;
    }

    // 评论区dalao的简化版本
    public int rob_3(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null)
            val += rob_3(root.left.left) + rob_3(root.left.right);
        if (root.right != null)
            val += rob_3(root.right.left) + rob_3(root.right.right);

        return Math.max(val + root.val, rob_3(root.left) + rob_3(root.right));
    }

    // 自己最开始的想法
    public int rob_4(TreeNode root) {
        if (root == null) return 0;
        int robThis = root.val + robSub_2(root.left) + robSub_2(root.right);
        int notRobThis = rob_4(root.left) + rob_4(root.right);
        return robThis > notRobThis ? robThis : notRobThis;
    }

    private int robSub_2(TreeNode node) {
        if (node == null) return 0;
        return rob_4(node.left) + rob_4(node.right);
    }
}
