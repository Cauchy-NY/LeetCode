package Easy;

import java.util.HashSet;
import java.util.Set;

public class Question202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            n = digitSquareSum(n);
            if (!set.add(n))
                return false;
        }
        return true;
    }

    public boolean isHappy_2(int n) {
        int slow = n, fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);

        if (slow == 1) return true;
        else return false;
    }

    private int digitSquareSum(int n) {
        int tmp = 0;
        while (n != 0) {
            tmp += Math.pow(n % 10, 2);
            n /= 10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        new Question202().isHappy(19);
    }
}
