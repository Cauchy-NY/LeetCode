package Medium;

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
