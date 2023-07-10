package Easy;

public class Question415 {
    public String addStrings(String num1, String num2) {
        int len = Math.min(num1.length(), num2.length());
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int a = num1.charAt(num1.length() - i - 1) - '0';
            int b = num2.charAt(num2.length() - i - 1) - '0';
            int sum = a + b + carry;
            builder.append(sum % 10);
            carry = sum / 10;
        }
        String left = len == num1.length() ? num2 : num1;
        for (int i = left.length() - len - 1; i >= 0; i--) {
            int sum = left.charAt(i) - '0' + carry;
            builder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Question415 question415 = new Question415();
        System.out.println(question415.addStrings("11", "123"));
        System.out.println(question415.addStrings("456", "77"));
        System.out.println(question415.addStrings("0", "0"));
    }
}
