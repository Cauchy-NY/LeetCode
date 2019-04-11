package Medium;

public class Question343 {
    // 这本质上是道数学题
    // (n-1) * 1 < n 显然永远成立
    // (n/2) * (n/2) > n 在 n > 4 时候成立
    // 所以如果乘以一个大于4的单数，我们可以将其拆分为更小的几个数乘积
    // 简单举例比较一下 3*3 > 2*2*2，所以我们尽可能拆分为一堆3相乘
    // 所以如果这个数 n > 4,我们将其拆为 (n-3) * 3
    // 如果 n = 4，1*3 显然不划算 2*2 = 1*4，直接乘4即可
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int product = 1;
        for (; n > 4; product *= 3, n -= 3);
        product *= n;

        return product;
    }
}
