package Easy;

public class Question342 {
    // 4的幂一定是2的。
    // 4的幂和2的幂一样，只会出现一位1。但是，4的1总是出现在奇数位。
    // 0x5 = 0101b 可以用来校验奇数位上的1。
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
