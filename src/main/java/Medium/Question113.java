package Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> tmp = new ArrayList<>();
        if (root == null)
            return tmp;

        backtrack(tmp, new ArrayList<>(), root);

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list: tmp) {
            int p = 0;
            for (int i: list)
                p += i;
            if (p == sum)
                res.add(list);
        }
        return res;
    }

    private void backtrack(List<List<Integer>> tmp, List<Integer> nums, TreeNode node) {
        if (isLeaf(node)) {
            nums.add(node.val);
            tmp.add(new ArrayList<>(nums));
            nums.remove(nums.size()-1);
        } else {
            if (node.left != null) {
                nums.add(node.val);
                backtrack(tmp, nums, node.left);
                nums.remove(nums.size()-1);
            }
            if (node.right != null) {
                nums.add(node.val);
                backtrack(tmp, nums, node.right);
                nums.remove(nums.size()-1);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
