package Easy;

public class Question1576 {
    public String modifyString(String s) {
        StringBuffer buffer = new StringBuffer();
        char before = 'a' - 1;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != '?') {
                if (buffer.length() != 0) {
                    char tmp = buffer.charAt(buffer.length() - 1);
                    if (cur == tmp) {
                        buffer.deleteCharAt(buffer.length() - 1);
                        buffer.append((char) ((tmp - 'a' + 1) % 26 + 'a'));
                    }
                }

                buffer.append(cur);
                before = cur;
            } else {
                len++;
                buffer.append((char) ('a' + (before + len - 'a') % 26));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Question1576 question = new Question1576();
        System.out.println(question.modifyString("?sdbjac"));
        System.out.println(question.modifyString("???sdbjac"));
        System.out.println(question.modifyString("sdbjac??"));
        System.out.println(question.modifyString("a?bjac"));
    }
}
