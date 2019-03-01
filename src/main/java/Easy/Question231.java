package Easy;

public class Question231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n&(n-1)) == 0;
    }

    public boolean isPowerOfTwo_2(int n) {
        if (n == 0)
            return false;

        while (n != 0) {
            if ((n%2) != 0 && n != 1)
                return false;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        new Question231().isPowerOfTwo_2(16);
    }
}
