package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question349 {
    // 尽可能少开空间
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] small = nums1.length < nums2.length ? nums1 : nums2;
        int[] big = nums1.length >= nums2.length ? nums1 : nums2;

        Set<Integer> set = new HashSet<>();
        for (int num: small) set.add(num);

        Set<Integer> resSet = new HashSet<>();
        for (int num: big) {
            if (set.contains(num)) resSet.add(num);
        }

        int[] res = new int[resSet.size()];
        int k = 0;
        for (Integer num: resSet) res[k++] = num;

        return res;
    }

    // 双指针
    public int[] intersection_2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num: set) result[k++] = num;

        return result;
    }

    // 二分
    public int[] intersection_3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);

        for (Integer num : nums1) {
            if (binarySearch(nums2, num))
                set.add(num);
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num: set) result[k++] = num;

        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
