package Easy;

import java.util.Deque;
import java.util.LinkedList;

public class Question482 {
    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if ('a' <= c && c <= 'z') {
                c += 'A' - 'a';
            }
            stack.push(c);
        }

        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (++cnt == k) {
                builder.append('-');
                cnt = 0;
            }
        }
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == '-') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Question482 question = new Question482();
        System.out.println(question.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(question.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(question.licenseKeyFormatting("---", 3));
    }
}
