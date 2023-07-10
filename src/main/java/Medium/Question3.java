package Medium;

import java.util.HashSet;
import java.util.Set;

public class Question3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;
        while (j < s.length()) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            maxLen = Math.max(maxLen, j - i);
            while (i < j && j < s.length() && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Question3 question = new Question3();
        System.out.println(question.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(question.lengthOfLongestSubstring("bbbbb"));
        System.out.println(question.lengthOfLongestSubstring("pwwkew"));
    }
}
