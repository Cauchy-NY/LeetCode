package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    private final Set<String> set = new HashSet<>();

    public List<String> generateParenthesis2(int n) {
        backtrack("", n);
        return new ArrayList<>(set);
    }

    private void backtrack(String str, int n) {
        if (str.length() == n * 2) {
            set.add(str);
            return;
        }
        backtrack(str + "()", n);
        backtrack("()" + str, n);
        backtrack("(" + str + ")", n);
    }
}
