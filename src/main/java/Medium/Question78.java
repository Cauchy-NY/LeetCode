package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            combine(subset, nums, nums.length, i);
        return subset;
    }

    public void combine(List<List<Integer>> subset, int[] nums, int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(subset, new ArrayList<>(), nums, 0, n, k);
    }

    private void backtrack(List<List<Integer>> res, List<Integer> combination, int[] nums, int begin, int n, int k) {
        if (combination.size() == k)
            res.add(new ArrayList<>(combination));
        else {
            for (int i = begin; i < n; i++) {
                combination.add(nums[i]);
                backtrack(res, combination, nums, i+1, n, k);
                combination.remove(combination.size()-1);
            }
        }
    }
}
