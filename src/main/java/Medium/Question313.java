package Medium;

public class Question313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] primesPointers = new int[primes.length];
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            // 取当前最小超级丑数
            for (int j = 0; j < primes.length; j++)
                res[i] = Math.min(res[i], res[primesPointers[j]] * primes[j]);
            // 去重
            for (int j = 0; j < primes.length; j++)
                while (primes[j] * res[primesPointers[j]] <= res[i]) primesPointers[j]++;
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,  7, 13, 19};
        new Question313().nthSuperUglyNumber(n, primes);
    }
}
