package Easy;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Question501 {

    private int maxLen = Integer.MIN_VALUE;

    private int curLen;

    private int curNum;

    private final List<Integer> maxNums = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        if (curLen > maxLen) {
            maxNums.clear();
            maxNums.add(curNum);
            maxLen = curLen;
        } else if (curLen == maxLen) {
            maxNums.add(curNum);
        }

        int[] ret = new int[maxNums.size()];
        for (int i = 0; i < maxNums.size(); i++) {
            ret[i] = maxNums.get(i);
        }
        return ret;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (curNum == node.val) {
            curLen++;
        } else {
            if (curLen > maxLen) {
                maxNums.clear();
                maxNums.add(curNum);
                maxLen = curLen;
            } else if (curLen == maxLen) {
                maxNums.add(curNum);
            }
            curLen = 1;
            curNum = node.val;
        }
        dfs(node.right);
    }
}
