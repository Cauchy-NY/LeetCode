package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        backtrack(result, new ArrayList<>(), s);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> step, String s) {
        if (s.length() == 0 || s == null)
            result.add(new ArrayList<>(step));
        else {
            for(int i = 1; i <= s.length(); i++) {
                String temp = s.substring(0, i);
                if(!isPalindrome(temp))
                    continue; // only do backtracking when current string is palindrome

                step.add(temp);  // choose
                backtrack(result, step, s.substring(i)); // explore
                step.remove(step.size()-1); // unchoose
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length()-1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}
