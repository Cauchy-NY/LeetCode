package Easy;

public class Question66 {
    public int[] plusOne(int[] digits) {
        int carrying = 0;
        digits[digits.length-1] += 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int tmp = digits[i] + carrying;
            digits[i] = tmp % 10;
            carrying = tmp / 10;
        }
        if (carrying > 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carrying;
            for (int i = 0; i < digits.length; i++)
                newDigits[i+1] = digits[i];
            digits = newDigits;
        }
        return digits;
    }

    public static void main(String...args) {
        new Question66().plusOne(new int[]{9});
    }
}
