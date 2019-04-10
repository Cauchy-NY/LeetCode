package Hard;

import java.util.*;

public class Question336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2)
            return res;

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++)
            map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i)
                        res.add(Arrays.asList(map.get(str2rvs), i));
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0)
                        res.add(Arrays.asList(i, map.get(str1rvs)));
                }
            }
        }
        return res;
    }

    // TLE 不出意外
    public List<List<Integer>> palindromePairs_1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPalindrome(words[i]+words[j]))
                    res.add(Arrays.asList(i, j));
                if (isPalindrome(words[j]+words[i]))
                    res.add(Arrays.asList(j, i));
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length()-1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}
