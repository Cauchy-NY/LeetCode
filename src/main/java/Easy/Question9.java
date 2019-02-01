package Easy;

public class Question9 {

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else {
            int reverse = 0, input = x;
            while(x != 0) {
                reverse = reverse*10 + x%10;
                x /= 10;
            }
            return reverse == input;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
