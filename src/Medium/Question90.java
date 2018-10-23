package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        backtrack(res, each, 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length)
            res.add(each);
        for (int i = pos; i < n.length;) {
            each.add(n[i]);
            backtrack(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1])
                i++;
        }
    }
}
