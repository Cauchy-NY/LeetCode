package Hard;

import java.util.Stack;

public class Question224 {
    // 碰到'('压栈保存当前result和sign，清空result，继续计算
    // 碰到')'出栈之前保存的result和sign，合并运算
    public int calculate(String s) {
        int sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;

            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    sum = sum*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}
