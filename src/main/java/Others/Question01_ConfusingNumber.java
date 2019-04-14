package Others;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. 易混淆数
 *
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 *
 * 把原数字旋转180°以后得到新的数字。
 *
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 *
 * 2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
 *
 * 易混淆数字 (confusing number) 就是一个数字旋转180°以后，得到和原来不同的数字，且新数字的每一位都是有效的。
 *
 * 提示：
 *
 * 1. 0 <= N <= 10^9
 * 2. 可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。
 */
public class Question01_ConfusingNumber {
    public boolean confusingNumber(int N) {
        Set<Integer> set = new HashSet<>();
        set.add(2); set.add(3); set.add(4); set.add(5); set.add(7);
        int reverse = 0, n = N;
        while (n > 0) {
            int tmp = n % 10;
            n /= 10;
            if (set.contains(tmp))
                return false;
            reverse *= 10;
            reverse += (tmp == 0 || tmp == 1 || tmp == 8) ? tmp : tmp == 6 ? 9 : 6;
        }
        return reverse != N;
    }
}
