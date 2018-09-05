package Medium;

public class Question5 {

    public String longestPalindrome(String s) {
        if(s == null || s == "")
            return "";
        else {
            int i = 0, j = s.length(), len = s.length();
            while(!isPalindrome(s.substring(i, j))) {
                if(i != 0) {
                    i--;
                    j--;
                }
                else {
                    len--;
                    j = s.length();
                    i = j - len;
                }
            }
            return s.substring(i, j);
        }
    }

    public boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;
        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
