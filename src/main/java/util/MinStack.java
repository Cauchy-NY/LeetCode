package util;

import java.util.Stack;

public class MinStack {

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    public MinStack() {}

    public void push(int x) {
        // 如果比最小值小，则更新之前将当前最小值压入栈
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 第一次pop出的如果是当前最小值，则当时push时必然压入了上一个最小值
        // pop出来更新min即可
        if (stack.pop() == min)
            min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
