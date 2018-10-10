package Medium;

public class Question50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                n = Integer.MAX_VALUE-1;
            else
                n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(new Question50().myPow(2.0, Integer.MIN_VALUE));
    }
}
