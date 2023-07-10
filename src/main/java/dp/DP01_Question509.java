package dp;

public class DP01_Question509 {

    // 更简单的，只记忆最近三个数值就可以
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }

    public static void main(String[] args) {
        DP01_Question509 question = new DP01_Question509();
        System.out.println(question.fib(0));
        System.out.println(question.fib(1));
        System.out.println(question.fib(2));
        System.out.println(question.fib(3));
    }
}
