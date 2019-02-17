package Easy;

public class Question172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

//    public int trailingZeroes(int n) {
//        int count = 0, res = 0;
//        while (Math.pow(5, count) < n)
//            count++;
//        while (count != 0) {
//            res += n / Math.pow(5, count);
//            count--;
//        }
//        return res;
//    }
}
