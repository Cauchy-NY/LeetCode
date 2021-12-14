package Medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question95 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<>();
        return generateSubTree(1, n);
    }

    private List<TreeNode> generateSubTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (end < start) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode l : generateSubTree(start, i-1)) {  //
                for (TreeNode r : generateSubTree(i+1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
