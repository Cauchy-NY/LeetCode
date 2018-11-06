package Medium;

import util.TreeNode;

public class Question105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return backtrack(0, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode backtrack(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;  // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val)
                inIndex = i;
        }
        root.left = backtrack(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = backtrack(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
