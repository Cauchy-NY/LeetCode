package Medium;

public class Question300 {
    // 如果需要将时间复杂度降为O(nlogn)，那么我们需要建立一个 maxLens 数组，
    // 这个数组和上一种思路的数组不同。上一种思路 maxLens[i] 的值代表 nums
    // 中第0个到第 i 个元素以 nums[i] 为最大值的最大递增序列长度。
    // 而这种思路的 maxLens[i] 代表 nums 中第0个到第 i 个元素最大长度为 i 的最小值
    // 是多少（注意最小值是 nums数组中的某个数）
    public int lengthOfLIS(int[] nums) {
        int[] maxLens = new int[nums.length+1];
        int maxLen = 0;
        for (int num: nums) {
            int len = binarySearch(num, maxLen, maxLens);
            maxLen = Math.max(len, maxLen);
            maxLens[len] = num;
        }
        return maxLen;
    }

    private int binarySearch(int num, int maxLen, int[] maxLens) {
        int left = 1, right = maxLen;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (maxLens[mid] < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
    
    // 建立一个大小与 nums 长度相等的数组 maxLens，用于记录每个 nums 最长长度，
    // 即 maxLens[i] 表示nums 第 0 个到第 i 个元素中以 nums[i]为最大值的最长子序列长度
    public int lengthOfLIS_2(int[] nums) {
        int[] maxLens = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    maxLens[i] = Math.max(maxLens[j]+1, maxLens[i]);
            maxLen = Math.max(maxLen, maxLens[i]+1);
        }
        return maxLen;
    }
}
