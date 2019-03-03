package Medium;

public class Question260 {
    // diff &= -diff 这一步可以直接方法2中的mask找出来
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;

        diff &= -diff;

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }

    // 思路, 先全部异或一次, 得到的结果，因为两个数是不同的，因此他们至少有一位是不同的
    // 那么只出现一次的两个数中, 在这个位上一个为0, 一个为1,从右到左找到这个数
    // 由此可以将数组中的元素分成两部分,重新遍历, 求两个异或值
    public int[] singleNumber_2(int[] nums) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;

        int mask = 1;
        while ((diff & mask) == 0)
            mask = mask << 1;

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & mask) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
