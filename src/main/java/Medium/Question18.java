package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int k = 4;
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < k)
            return list;
        Arrays.sort(nums);
        list = kSum(k, nums, target);
        return list;
    }

    public List<List<Integer>> kSum(int k, int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < k)
            return list;
        if(k == 2) {
            int lo = 0, hi = nums.length - 1;
            while(lo < hi) {
                if(nums[lo] + nums[hi] == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;
                    lo++;
                    hi--;
                }
                else if(nums[lo] + nums[hi] < target)
                    lo++;
                else
                    hi--;
            }
        }
        else {
            for (int i = 0; i < nums.length - k + 1; i++) {
                if (i == 0 || nums[i] != nums[i -1]) {
                    List<List<Integer>> tmp = kSum(k - 1, Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
                    for (List<Integer> l : tmp) {
                        l.add(nums[i]);
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }
}
