package Easy;

import Design.MyStack;

public class Question225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }
}
