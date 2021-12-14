package Hard;

import Design.Codec;
import utils.TreeNode;

public class Question297 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeNode.constructBinaryTree(new Integer[]{1,2,3,null,null,4,5});
        String str = codec.serialize(root);
        root = codec.deserialize(str);
    }
}
