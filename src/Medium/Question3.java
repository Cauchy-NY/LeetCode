package Medium;

import java.lang.reflect.Array;
import java.util.*;

public class Question3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s == "")
            return 0;
        else {
            int i = 0, j = 1, result = 0;
            while(j <= s.length()) {
                if(isRepeating(s.substring(i, j))) {
                    i++;
                    j++;
                }
                else {
                    j++;
                    result++;
                }
            }
            return result;
        }
    }

    public boolean isRepeating(String str) {
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();

        for(char c: chars) {
            if(list.contains(c))
                return true;
            else
                list.add(c);
        }

        return false;
    }
}
