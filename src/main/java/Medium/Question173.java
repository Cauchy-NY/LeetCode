package Medium;

import Design.BSTIterator;
import util.TreeNode;

public class Question173 {

    public static void main(String[] args) {
        Integer[] treeNums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeNode.constructBinaryTree(treeNums);

        BSTIterator iterator = new BSTIterator(root);
        iterator.next();    // 返回 3
        iterator.next();    // 返回 7
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 9
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 15
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 20
        iterator.hasNext(); // 返回 false
    }
}
