package Medium;

public class Question137 {
    // 模拟三进制运算
    // 除了结果之外的数的每个位上出现了 1 的次数为 3 的倍数
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; i++) {
            two |= (one & nums[i]);  // 当新来的为0时，two = two | 0，two不变，当新来的为1时，（当one此时为0，则two = two|0，two不变；当one此时为1时，则two = two | 1，two变为1
            one ^= nums[i];          // 新来的为0，one不变，新来为1时，one是0、1交替改变
            three = one & two;       // 当one和two为1是，three为1（此时代表要把one和two清零了）
            one &= ~three;           // 把one清0
            two &= ~three;           // 把two清0
        }
        return one;
    }
}
