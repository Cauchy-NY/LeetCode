package Hard;

import java.util.Arrays;

public class Question164 {
    // 评论区做法，基本思想是 gap = ceiling[(max - min ) / (N - 1)]
    // 每个bucket只记录该桶的最大最小值，最后再统计maxGap
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for (int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max-min) / (nums.length-1));
        int[] bucketsMIN = new int[nums.length-1]; // store the min value in that bucket
        int[] bucketsMAX = new int[nums.length-1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int num: nums) {
            if (num == min || num == max)
                continue;
            int idx = (num - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(num, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(num, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
    /**
     * 最后统计时有个比较疑惑的问题，评论区也给出了解答：
     * The maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
     *
     * This is because sum of gaps = max-min.
     * We have N-1 gaps in an array that contain N elements.
     * So if every gap is smaller than [(max - min ) / (N - 1)].
     * Then sum of gaps < (N-1)*[(max-min) / (N-1)]=max-min.
     * This is not possible since sum of gaps = max-min.
     */

//    // 计数排序空间复杂度为O(n+k)，k可能很大，故不行
//    public int maximumGap(int[] nums) {
//        if (nums == null || nums.length < 2)
//            return 0;
//
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int num: nums) {
//            max = Math.max(max, num);
//            min = Math.min(min, num);
//        }
//
//        int help[] = new int[max-min+1];
//        for (int num: nums)
//            help[num-min]++;
//
//        int maxCount = 0, tmpCount = 0;
//        int beginIndex = 0, endIndex = help.length-1;
//        while (help[beginIndex] == 0)
//            beginIndex++;
//        while (help[endIndex] == 0)
//            endIndex--;
//
//        for (int i = beginIndex; i <= endIndex; i++) {
//            if (help[i] != 0) {
//                maxCount = Math.max(maxCount, tmpCount);
//                tmpCount = 0;
//            } else
//                tmpCount++;
//        }
//        return maxCount+1;
//    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 6, 9, 1};
        int[] nums2  = new int[]{1, 2};
        System.out.println(new Question164().maximumGap(nums2));
    }
}
