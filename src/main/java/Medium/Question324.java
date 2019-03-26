package Medium;

import java.util.Arrays;
import java.util.Random;

public class Question324 {
    // O(n)时间，O(n)空间
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        int median = kthSmallestNumber(nums, m);

        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) swap(copy, i++, j++);
            else if (copy[j] > median) swap(copy, j, k--);
            else j++;
        }

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();

        for (int i = nums.length - 1; i >= 0; i--)
            swap(nums, i, random.nextInt(i + 1));

        int l = 0, r = nums.length - 1;
        k--;

        while (l < r) {
            int m = getMiddle(nums, l, r);

            if (m < k) l = m + 1;
            else if (m > k) r = m - 1;
            else break;
        }

        return nums[k];
    }

    private int getMiddle(int[] nums, int l, int r) {
        int i = l;

        for (int j = l + 1; j <= r; j++)
            if (nums[j] < nums[l]) swap(nums, ++i, j);

        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // naive方法的简化写法
    public void wiggleSort_2(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    // naive的方法，先排序再奇数位置从大到小排序，偶数位置接着从大到小排序
    // 时间O(nlogn)，空间O(n)
    public void wiggleSort_3(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int cur = res.length-1;
        for (int i = 1; i < res.length; i+=2, cur--)
            res[i] = nums[cur];
        for (int i = 0; i < res.length; i+=2, cur--)
            res[i] = nums[cur];
        for (int i = 0; i < res.length; i++)
            nums[i] = res[i];
    }
}
