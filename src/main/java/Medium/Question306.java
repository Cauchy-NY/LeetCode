package Medium;

public class Question306 {
    // 迭代解
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++)
            for (int j = 1; Math.max(j, i) <= n - i - j; j++)
                if (isValid(i, j, num)) return true;
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = String.valueOf(x2);
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }

    // 关键是确定前两个数字
    public boolean isAdditiveNumber_2(String num) {
        int n = num.length();
        // 第一个数字不可能超过整个序列的1/2
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1)
                return false;

            // 挑出第一个数字
            long x1 = Long.parseLong(num.substring(0, i));

            for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1)
                    break;

                // 挑出第二个数字
                long x2 = Long.parseLong(num.substring(i, i + j));

                // 检验以这两个数字开头是否可以
                if (isValid(x1, x2, j + i, num))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid(long x1, long x2, int start, String num) {
        if (start == num.length())
            return true;
        // 找下两个数的小trick
        x2 = x2 + x1;
        x1 = x2 - x1;
        String sum = String.valueOf(x2);
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}
