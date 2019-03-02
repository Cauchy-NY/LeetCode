package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int[] r = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0, ri = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();

            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1)
                r[ri++] = nums[q.peek()];
        }
        return r;
    }

    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 1 || k == 0)
            return nums;
        if (k > nums.length)
            return new int[] {findMax(nums, 0, nums.length)};

        int[] result = new int[nums.length-k+1];
        int index = findMax(nums, 0, k);
        result[0] = nums[index];
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            if (index < j) {
                index = findMax(nums, j, j+k);
                result[j] = nums[index];
                continue;
            }

            result[j] = nums[i] > result[j-1] ? nums[i] : result[j-1];
        }

        return result;
    }

    private int findMax(int[] nums, int begin, int end) {
        int max = Integer.MIN_VALUE, index = 0;
        for (int i = begin; i < end; i++)
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        new Question239().maxSlidingWindow_2(nums, 3);
    }
}
