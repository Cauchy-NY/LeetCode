package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if(!stack.isEmpty()) {
                    if(s.charAt(i) == '}' && stack.peek() == '{')
                        stack.pop();
                    else if(s.charAt(i) == ')' && stack.peek() == '(')
                        stack.pop();
                    else if(s.charAt(i) == ']' && stack.peek() == '[')
                        stack.pop();
                    else
                        break;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
