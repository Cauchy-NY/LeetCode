package Medium;

public class Question287 {
    /**
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素，
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素，
     * 即按照寻找链表环入口的思路来做
     * 注意：
     * 1. nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界)
     * 2. 出现死循环，即 num[index] = index 时，必然有 num[cur] = index, cur != index（总归是从什么地方跳进来的）
     *    所以 index 就是重复数字，一定会被追上
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
