package Easy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question257 {
    // 评论区dalao做法，添加路径的时候加上最后一个点，不存于path记录之中，最后就不用删除
    // 更加clean的代码
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();

        if (root != null)
            searchBT(root, "", answer);

        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null)
            answer.add(path + root.val);
        if (root.left != null)
            searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", answer);
    }

    // 我的做法
    public List<String> binaryTreePaths_2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Set<String> paths = new HashSet<>();
        List<Integer> nodeList = new ArrayList<>();

        dfs(paths, nodeList, root);

        return new ArrayList<>(paths);
    }

    private void dfs(Set<String> paths, List<Integer> nodeList, TreeNode cur) {
        nodeList.add(cur.val);

        if (cur.left == null && cur.right == null)
            paths.add(constructPath(nodeList));

        if (cur.left != null)
            dfs(paths, nodeList, cur.left);
        if (cur.right != null)
            dfs(paths, nodeList, cur.right);

        nodeList.remove(nodeList.size()-1);
    }

    private String constructPath(List<Integer> nodeList) {
        StringBuilder sb = new StringBuilder();
        for (int num: nodeList)
            sb.append(num+"->");
        return sb.substring(0, sb.length()-2);
    }
}
