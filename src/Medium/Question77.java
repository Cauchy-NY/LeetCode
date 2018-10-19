package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> combination, int begin, int n, int k) {
        if (combination.size() == k)
            res.add(new ArrayList<>(combination));
        else {
            for (int i = begin; i <= n; i++) {
                combination.add(i);
                backtrack(res, combination, i+1, n, k);
                combination.remove(combination.size()-1);
            }
        }
    }
}
