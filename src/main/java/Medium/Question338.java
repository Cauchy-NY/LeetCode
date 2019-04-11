package Medium;

public class Question338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int cur = 1;
        while (cur < res.length) {
            for (int i = cur; i < 2*cur && i < res.length; i++)
                res[i] = res[i-cur] + 1;
            cur *= 2;
        }
        return res;
    }
}
