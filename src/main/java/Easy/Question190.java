package Easy;

public class Question190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    // 👆上面代码的java内部实现，神仙操作
    public int reverseBits_2(int n) {
        int i = n;
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) | ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }

    // 普通操作
    public int reverseBits_3(int n) {
        int ans = 0;
        for (int i = 32; i > 0; i--) {
            ans <<= 1;
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }
}
