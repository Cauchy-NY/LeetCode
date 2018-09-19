package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words == null || words.length == 0 || s == null)
            return result;

        // init word num in word list
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int low = i;
            int count = 0;
            for (int high = low; high+wordLen <= s.length(); high += wordLen) {
                String tempword = s.substring(high, high+wordLen);
                if(map.containsKey(tempword)) {
                    temp.put(tempword, temp.getOrDefault(tempword, 0) + 1);
                    count++;
                    while (temp.get(tempword) > map.get(tempword)) {
                        String firstWord = s.substring(low, low+wordLen);
                        temp.put(firstWord, temp.get(firstWord)-1);
                        count--;
                        low += wordLen;
                    }
                    if(count == words.length) {
                        result.add(low);
                        String firstWord = s.substring(low, low+wordLen);
                        temp.put(firstWord, temp.get(firstWord)-1);
                        count--;
                        low += wordLen;
                    }
                }
                else {
                    temp.clear();
                    count = 0;
                    low = high + wordLen;
                }
            }
        }
        return result;
    }
}
