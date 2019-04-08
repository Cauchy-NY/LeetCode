package Medium;

public class Question331 {
    // 每一个非叶节点有一个入度两个出度，叶子节点有一个入度零个出度
    // 出度一定等于入度，叶子节点数=非叶节点数+1（根节点没有入度来抵消一个出度）
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        for (String node: preorder.split(",")) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        new Question331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
