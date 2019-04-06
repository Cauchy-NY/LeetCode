package Hard;

import java.util.TreeMap;

public class Question327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public int countRangeSum_2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;

        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sums[i] = sums[i-1] + nums[i];

        int total = 0;
        TreeMap<Long, Integer> treemap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lower <= sums[i] && sums[i] <= upper)
                total++;

            for(Integer count: treemap.subMap(sums[i]-upper, true, sums[i]-lower, true).values())
                total += count;

            Integer count = treemap.get(sums[i]);

            if (count == null) count = 1;
            else count ++;

            treemap.put(sums[i], count);
        }
        return total;
    }

    public int countRangeSum_3(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;

        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sums[i] = sums[i-1] + nums[i];

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long res = sums[j] - sums[i] + nums[i];
                if (lower <= res && res <= upper)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        new Question327().countRangeSum(nums, -2, 2);
    }
}
