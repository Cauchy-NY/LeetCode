package Easy;

import util.TreeNode;

public class Question100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
//    // 僵硬的一批，树的题还是要多写
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null)
//            return true;
//        if ((p == null && q != null) || (p != null && q == null))
//            return false;
//
//        if ((p.left == null && q.left != null) || (p.left != null && q.left == null))
//            return false;
//        if ((p.left != null && q.left != null) && !isSameTree(p.left, q.left))
//            return false;
//        if (p.val != q.val)
//            return false;
//        if ((p.right == null && q.right != null) || (p.right != null && q.right == null))
//            return false;
//        if ((p.right != null && q.right != null) && !isSameTree(p.right, q.right))
//            return false;
//
//        return true;
//    }
}
