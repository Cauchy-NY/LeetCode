package Easy;

public class Question70 {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
