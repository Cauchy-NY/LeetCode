package Medium;

public class Question151 {
    public String reverseWords(String s) {
        if (s == null || s.trim().equals(""))
            return "";

        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("\\s+");
        for (int i = strs.length-1; i >= 0; i--)
            if (!strs[i].equals(" "))
                sb.append(strs[i] + (i == 0 ? "" : " "));

        return sb.toString();
    }
}
