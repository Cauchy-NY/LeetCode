package Easy;

public class Question125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String...args) {
        System.out.println(new Question125().isPalindrome("0P"));
    }
}
