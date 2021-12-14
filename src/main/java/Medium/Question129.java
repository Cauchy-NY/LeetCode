package Medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question129 {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        List<Integer> pathList = new ArrayList<>();
        backtrack(root, pathList, new ArrayList<>());

        int res = 0;
        for (int num: pathList)
            res += num;
        return res;
    }

    private void backtrack(TreeNode node, List<Integer> pathList, List<Integer> path) {
        path.add(node.val);
        if (node.left == null && node.right == null)
            pathList.add(sum(path));
        else {
            if (node.left != null)
                backtrack(node.left, pathList, path);
            if (node.right != null)
                backtrack(node.right, pathList, path);
        }
        path.remove(path.size()-1);
    }

    private int sum(List<Integer> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++)
            sum += path.get(i) * Math.pow(10, path.size()-i-1);
        return sum;
    }

    public static void main(String...args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;
        new Question129().sumNumbers(root);
    }
}
