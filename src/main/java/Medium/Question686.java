package Medium;

import java.util.HashSet;
import java.util.Set;

public class Question686 {

    public int repeatedStringMatch(String a, String b) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            if (!set.contains(b.charAt(i))) {
                return -1;
            }
        }

        int count = 1;
        String repeatedA = a;
        while (repeatedA.length() < b.length()) {
            repeatedA += a;
            count++;
        }

        while (repeatedA.length() <= b.length() * 2 || count < 3) {
            if (isMatch(repeatedA, b)) {
                return count;
            }
            repeatedA += a;
            count++;
        }

        return -1;
    }

    private boolean isMatch(String a, String b) {
        return a.contains(b);
    }

    public static void main(String[] args) {
        Question686 question = new Question686();
        System.out.println(question.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
        System.out.println(question.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(question.repeatedStringMatch("a", "aa"));
        System.out.println(question.repeatedStringMatch("a", "a"));
        System.out.println(question.repeatedStringMatch("abc", "wxyz"));
    }
}
