package dp;

public class DP02_Question1137 {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int num1 = 0, num2 = 1, num3 = 1;
        for (int i = 3; i <= n; i++) {
            int num = num1 + num2 + num3;
            num1 = num2;
            num2 = num3;
            num3 = num;
        }
        return num3;
    }

    public static void main(String[] args) {
        DP02_Question1137 question = new DP02_Question1137();
        System.out.println(question.tribonacci(4));
        System.out.println(question.tribonacci(25));
    }
}
