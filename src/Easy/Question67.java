package Easy;

import java.util.ArrayList;

public class Question67 {
    public String addBinary(String a, String b) {
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;
        String s1 = a.length() >= b.length() ? a : b;  // bigger
        String s2 = a.length() < b.length() ? a : b;  // smaller
        ArrayList<Integer> sum = new ArrayList<>();
        int carrying = 0;
        for (int i = s2.length()-1; i >= 0; i--) {
            int tmp = (s1.charAt(i+s1.length()-s2.length())-'0') + (s2.charAt(i)-'0') + carrying;
            sum.add(tmp % 2);
            carrying = tmp / 2;
        }
        for (int i = s1.length()-s2.length()-1; i >= 0; i--) {
            int tmp = (s1.charAt(i)-'0') + carrying;
            sum.add(tmp % 2);
            carrying = tmp / 2;
        }
        if (carrying > 0)
            sum.add(carrying);
        StringBuilder sb = new StringBuilder();
        for (int i = sum.size()-1; i >= 0; i--)
            sb.append(sum.get(i));
        return sb.toString();
    }

    public static void main(String...args) {
        new Question67().addBinary("110010", "100");
    }
}
