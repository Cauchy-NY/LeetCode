package Easy;

public class Question58 {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0)
            return 0;
        else
            return strs[strs.length-1].length();
    }

    public static void main(String[] args) {
        String s = " ";
        String[] strs = s.split(" ");
    }
}
