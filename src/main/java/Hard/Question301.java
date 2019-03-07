package Hard;

import java.util.*;

public class Question301 {
    // 评论区的这个想法和我的思路比较像，看长度为n的里面是否有符合的，有就搜一遍
    // 长度为n都没有就搜n-1的子序列，我的答案问题是把子序列看成了子串
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                res.add(s);
                found = true;
            }

            if (found) continue; // 如果找到说明这个长度就有答案了，不再向下进行搜索

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i+1);

                if (visited.add(t))
                    queue.add(t);
            }
        }

        return res;
    }

    boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }

    // 这是一个神仙操作
    public List<String> removeInvalidParentheses_2(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j+1), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public static void main(String[] args) {
        new Question301().removeInvalidParentheses("()())()");
    }

//    // 有问题，这个的本质是子序列而不是子串
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> res = new ArrayList<>();
//        if (s == null || s.equals(""))
//            return res;
//
//        if (isValid(s)) {
//            res.add(s);
//            return res;
//        }
//
//        int subLen = s.length()-1;
//        for (int j = 0; j+subLen <= s.length(); j++)
//            res.addAll(removeInvalidParentheses(s.substring(j, j+subLen)));
//
//        int maxLen = Collections.max(res, Comparator.comparingInt(String::length)).length();
//
//        res.forEach(a -> {
//            if (a.length() < maxLen) res.remove(a);
//        });
//
//        return res;
//    }
//
//    private boolean isValid(String str) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '(')
//                stack.push('(');
//            if (str.charAt(i) == ')') {
//                if (stack.isEmpty()) return false;
//                else stack.pop();
//            }
//        }
//        return stack.isEmpty();
//    }
}
