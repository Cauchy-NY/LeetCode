package Easy;

import java.util.Arrays;

public class Question242 {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        for (char c: s.toCharArray())
            counter[c-'a']++;
        for (char c: t.toCharArray())
            counter[c-'a']--;

        for (int count: counter) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram_2(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i])
                return false;
        }
        return true;
    }
}
