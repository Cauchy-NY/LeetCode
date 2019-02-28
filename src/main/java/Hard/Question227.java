package Hard;

import java.util.Stack;

public class Question227 {
    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + (s.charAt(i) - '0');

            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1) {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else if (sign == '/')
                    stack.push(stack.pop() / num);

                sign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        for (int tmpRes: stack)
            result += tmpRes;
        return result;
    }

    public static void main(String[] args) {
        new Question227().calculate(" 3/2 ");
    }
}
