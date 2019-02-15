package Medium;

import java.util.Stack;

public class Question150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            } else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            } else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String... args) {
        String[] tokens1 = new String[] {"4", "13", "5", "/", "+"};
        new Question150().evalRPN(tokens1);
    }
}
