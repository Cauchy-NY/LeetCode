package Easy;

import Design.MinStack;

public class Question155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // --> 返回 -3.
        minStack.pop();
        minStack.top();      // --> 返回 0.
        minStack.getMin();   // --> 返回 -2.
    }
}
