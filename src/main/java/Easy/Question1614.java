package Easy;

public class Question1614 {

    public int maxDepth(String s) {
        int ans = 0, size = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++size;
                ans = Math.max(ans, size);
            } else if (ch == ')') {
                --size;
            }
        }
        return ans;
    }

// sb
//    public int maxDepth(String s) {
//        return dfs(s);
//    }
//
//    private int dfs(String s) {
//        if (s == null || s.equals(""))
//            return 0;
//
//        Stack<Character> stack = new Stack<>();
//        List<String> vpss = new ArrayList<>();
//
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//            if (cur == '(') {
//                if (stack.isEmpty())
//                    start = i;
//                stack.push(cur);
//            } else if (cur == ')') {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    vpss.add(s.substring(start + 1, i));
//                }
//            }
//        }
//
//        if (vpss.isEmpty())
//            return 0;
//
//        int maxDepth = 0;
//        for (String vps : vpss) {
//            maxDepth = Math.max(maxDepth, dfs(vps));
//        }
//        return maxDepth + 1;
//    }

    public static void main(String[] args) {
        Question1614 question = new Question1614();
        System.out.println(question.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(question.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(question.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(question.maxDepth("1"));
    }
}
