package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        addAll(res, nums);
        while (!isDesc(nums)) {
            for (int i = nums.length-1; i > 0; i--) {
                if(nums[i] > nums[i-1]) {
                    int max = Integer.MAX_VALUE;
                    int maxIndex = 0;
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] < max && nums[j] > nums[i-1]) {
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                    swap(nums, i-1, maxIndex);
                    Arrays.sort(nums, i, nums.length);
                    addAll(res, nums);
                    break;
                }
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void addAll(List<List<Integer>> res, int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int i: nums)
            tmp.add(i);
        res.add(tmp);
    }

    private boolean isDesc(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question47 q = new Question47();
        int[] nums = new int[] {1, 1, 2, 2};
        List<List<Integer>> res = q.permuteUnique(nums);
        for (List<Integer> list: res) {
            for (int i: list)
                System.out.print(i);
            System.out.println();
        }
    }
}
