package Hard;

public class Question321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

//    // 错误解法，相同的时候无法决定选上面还是选下面
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int[] res = new int[k];
//        int searchLen = nums1.length + nums2.length - k;
//        for (int i = 0; i < k; i++) {
//            searchLen = put(nums1, nums2, res, k-i, i, searchLen);
//        }
//        return res;
//    }
//
//    private int put(int[] nums1, int[] nums2, int[] res, int k, int cur, int searchLen) {
//        int index = 0, tag = 1, max = Integer.MIN_VALUE;
//        int begin1 = 0, begin2 = 0;
//
//        while (begin1 < nums1.length && nums1[begin1] == Integer.MIN_VALUE)
//            begin1++;
//        while (begin2 < nums2.length && nums2[begin2] == Integer.MIN_VALUE)
//            begin2++;
//
//        for (int i = begin1; i < nums1.length && i <= begin1+searchLen; i++) {
//            if (nums1[i] > max) {
//                max = nums1[i];
//                index = i;
//            }
//        }
//        for (int i = begin2; i < nums2.length && i <= begin2+searchLen; i++) {
//            if (nums2[i] > max) {
//                max = nums2[i];
//                index = i;
//                tag = 2;
//            }
//        }
//
//        res[cur] = max;
//        searchLen++;
//
//        if (tag == 1) {
//            for (int i = begin1; i <= index; i++) {
//                nums1[i] = Integer.MIN_VALUE;
//                searchLen--;
//            }
//        }
//        if (tag == 2) {
//            for (int i = begin2; i <= index; i++) {
//                nums2[i] = Integer.MIN_VALUE;
//                searchLen--;
//            }
//        }
//
//        return searchLen;
//    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        new Question321().maxNumber(nums1, nums2, 5);

        int[] nums3 = {6, 7};
        int[] nums4 = {6, 0, 4};
        new Question321().maxNumber(nums3, nums4, 5);
    }
}
