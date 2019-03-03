package Easy;

public class Question258 {
    // For base b (decimal case b = 10), the digit root of an integer is:
    //   dr(n) = 0 if n == 0
    //   dr(n) = (b-1) if n != 0 and n % (b-1) == 0
    //   dr(n) = n mod (b-1) if n % (b-1) != 0
    // 综上，dr(n) = 1 + (n - 1) % 9
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public int addDigits_2(int num) {
        while (num > 9) {
            int tmp = 0;
            while (num != 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }
}
