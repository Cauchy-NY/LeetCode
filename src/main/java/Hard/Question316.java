package Hard;

import java.util.Arrays;
import java.util.Stack;

public class Question316 {
    // 递归解法，代码难看，但是比较好理解
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i)-'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--counter[s.charAt(i)-'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) +
                removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    // 使用栈，原po没有代码洁癖好难受
    public String removeDuplicateLetters_2(String s) {
        int[] res = new int[26];  // will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26];  // will contain if character (i+'a') is present in current result Stack
        char[] chars = s.toCharArray();
        for (char c: chars)  // count number of occurences of character
            res[c-'a']++;

        Stack<Character> stack = new Stack<>(); // answer stack
        for (char c: chars) {
            res[c-'a']--;   // decrement number of characters remaining in the string to be analysed
            if (visited[c-'a']) // if character is already present in stack, dont bother
                continue;
            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!stack.isEmpty() && c < stack.peek() && res[stack.peek()-'a'] != 0)
                visited[stack.pop()-'a'] = false;

            stack.push(c); // add current character and mark it as visited
            visited[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!stack.isEmpty())
            sb.insert(0,stack.pop());
        return sb.toString();
    }

//    // 错误解法，逻辑上有漏洞
//    public String removeDuplicateLetters(String s) {
//        char[] chars = s.toCharArray();
//        int[] index = new int[26];
//        Arrays.fill(index, -1);
//
//        for (int i = 0; i < chars.length; i++) {
//            if (index[chars[i]-'a'] != -1) {
//                for (int j = 0; j < chars[i]-'a'; j++) {
//                    if (index[j] != -1) {
//                        chars[index[chars[i]-'a']] = 0;
//                        break;
//                    }
//                }
//                if (chars[index[chars[i]-'a']] == 0)
//                    index[chars[i]-'a'] = i;
//                else
//                    chars[i] = 0;
//            } else
//                index[chars[i]-'a'] = i;
//        }
//
//        StringBuilder res = new StringBuilder();
//        for (char c: chars) {
//            if (c != 0) res.append(c);
//        }
//        return res.toString();
//    }
}
