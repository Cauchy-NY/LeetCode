package Easy;

import java.util.*;

public class Question290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;

        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            // put操作会返回之前的value值，即第一次遇到假设是匹配的，后面看是否会没有同步修改
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public boolean wordPattern_2(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i]))
                    return false;
            } else if (reverseMap.containsKey(strs[i]))
                return false;
            else {
                map.put(c, strs[i]);
                reverseMap.put(strs[i], c);
            }
        }
        return true;
    }
}
