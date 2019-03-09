package Medium;

import java.util.Stack;

public class Question946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

    public boolean validateStackSequences_2(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length < popped.length)
            return false;

        if (popped.length == 0)
            return true;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 0; i < popped.length; i++) {
            while ((stack.isEmpty() || stack.peek() != popped[i]) && j < pushed.length)
                stack.push(pushed[j++]);

            if (stack.pop() != popped[i])
                return false;
        }
        return true;
    }
}
