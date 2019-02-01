package Medium;

import util.TreeNode;

public class Question106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return backtrack(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }

    private TreeNode backtrack(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < 0 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i])
                inIndex = i;
        }
        root.left = backtrack(postEnd-(inEnd-inIndex)-1, inStart, inIndex-1, inorder, postorder);
        root.right = backtrack(postEnd-1, inIndex+1, inEnd, inorder, postorder);
        return root;
    }
}
