package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question132 {

    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }


//    // 超内存orz
//    public int minCut(String s) {
//        List<List<String>> result = new ArrayList<>();
//        if (s == null || s.length() == 0)
//            return 0;
//        backtrack(result, new ArrayList<>(), s);
//        return result.stream().min(Comparator.comparingInt(List::size)).get().size()-1;
//    }
//
//    private void backtrack(List<List<String>> result, List<String> step, String s) {
//        if (s.length() == 0 || s == null)
//            result.add(new ArrayList<>(step));
//        else {
//            for(int i = 1; i <= s.length(); i++) {
//                String temp = s.substring(0, i);
//                if(!isPalindrome(temp))
//                    continue; // only do backtracking when current string is palindrome
//
//                step.add(temp);  // choose
//                backtrack(result, step, s.substring(i)); // explore
//                step.remove(step.size()-1); // unchoose
//            }
//        }
//    }
//
//    private boolean isPalindrome(String str) {
//        for (int i = 0, j = str.length()-1; i < j; i++, j--) {
//            if (str.charAt(i) != str.charAt(j))
//                return false;
//        }
//        return true;
//    }
}
