package Medium;

import java.util.Stack;

public class Question71 {
    public String simplifyPath(String path) {
        String res = new String();
        Stack<String> stack = new Stack<>();
        for (String str: path.split("/")) {
            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else if (str.equals(".") || str.equals(""))
                continue;
            else
                stack.push(str);
        }
        for (String str: stack)
            res += "/" + str;
        return res.equals("") ? "/" : res;
    }
}
