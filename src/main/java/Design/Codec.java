package Design;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return constructTree(queue);
    }

    private static TreeNode constructTree(Queue<String> strs) {
        String str = strs.poll();
        if (str.equals("null"))
            return null;

        TreeNode newNode = new TreeNode(Integer.parseInt(str));
        newNode.left = constructTree(strs);
        newNode.right = constructTree(strs);
        return newNode;
    }
}
