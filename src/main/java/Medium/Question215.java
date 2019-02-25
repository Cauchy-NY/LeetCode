package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question215 {
    // 维护一个大小为k的最小堆
    // 时间复杂度 O(NlogK) 、空间复杂度 O(K)
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    // quick select
    // 时间复杂度 O(N)、空间复杂度 O(1)
    public int findKthLargest_2(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        int ans, pos = nums.length-k;
        while ((ans=partition(nums, left, right)) != pos)
            if (ans < pos)
                left = ans + 1;
            else
                right = ans - 1;
        return nums[nums.length-k];
    }

    private int partition(int[] nums, int left, int right) {
        int val = nums[right];
        for (int i = left; i < right; i++)
            if (nums[i] < val)
                swap(nums, left++, i);
        swap(nums, right, left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
