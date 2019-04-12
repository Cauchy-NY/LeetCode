package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0, j = chars.length; i < j; i++, j--) {
            while (!set.contains(Character.toLowerCase(chars[i])) && i < j) i++;
            while (!set.contains(Character.toLowerCase(chars[j])) && i < j) j--;

            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
