package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question216 {
    // backtrack
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }

    // 从 LeetCode 40 修改而来，居然能过orz
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        return combinationSum2(candidates, k, n);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int len, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, len, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int len, List<Integer> tempList, int [] nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0 && tempList.size() == len)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1])
                    continue;
                tempList.add(nums[i]);
                backtrack(list, len, tempList, nums, remain - nums[i], i+1);  // cannot reuse
                tempList.remove(tempList.size() - 1);  // to continue this loop
            }
        }
    }
}
