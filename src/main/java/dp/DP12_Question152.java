package dp;

public class DP12_Question152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int max = dpMax[0];
        for (int i = 1; i < dpMax.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i], nums[i] * dpMax[i - 1]), nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMin[i - 1]), nums[i] * dpMax[i - 1]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    /**
     * 更简单一点的实现 swap
     * int maxProduct(int A[], int n) {
     *     // store the result that is the max we have found so far
     *     int r = A[0];
     *
     *     // imax/imin stores the max/min product of
     *     // subarray that ends with the current number A[i]
     *     for (int i = 1, imax = r, imin = r; i < n; i++) {
     *         // multiplied by a negative makes big number smaller, small number bigger
     *         // so we redefine the extremums by swapping them
     *         if (A[i] < 0)
     *             swap(imax, imin);
     *
     *         // max/min product for the current number is either the current number itself
     *         // or the max/min by the previous number times the current one
     *         imax = max(A[i], imax * A[i]);
     *         imin = min(A[i], imin * A[i]);
     *
     *         // the newly computed max value is a candidate for our global result
     *         r = max(r, imax);
     *     }
     *     return r;
     * }
     * */

    public static void main(String[] args) {
        DP12_Question152 question = new DP12_Question152();
        System.out.println(question.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(question.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(question.maxProduct(new int[]{-2, 3, -4}));
    }
}
