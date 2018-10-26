package Medium;

/**
 * 可以看到这是一个中序有序的二叉树，根据二叉搜索树的性质，一个节点左子树值都要比本身小，右子树节点值都比本身大。
 * 以一个节点为根能产生的有效的树的数量由左右子树的数量决定，即假设左子树数量为a，右子树数量为b，则以此节点为根的树的数量为a*b。
 * 对于一个n，从1 - n均可作为结点，因此把从1-n作为结点产生的树的数量相加即可得到n的所有子树的数量。
 * 状态转移方程为：dp[n] = sum(dp[i-1] * dp[n-i]), 1 <= i <= n。
 * 这同样也可以看成卡特兰数。
 */
public class Question96 {
    // Catalan Number
    public int numTrees(int n) {
        int [] catalanNum = new int[n+1];
        catalanNum[0] = catalanNum[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                catalanNum[i] += catalanNum[j-1] * catalanNum[i-j];
            }
        }
        return catalanNum[n];
    }
}
