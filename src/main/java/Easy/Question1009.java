package Easy;

public class Question1009 {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        int cur = 0;
        while (cur < binary.length() && binary.charAt(cur) == '1') {
            cur++;
        }
        if (cur == binary.length())
            return 0;

        int ans = 1;
        for (int i = cur + 1; i < binary.length(); i++) {
            ans = binary.charAt(i) == '1' ? ans * 2 : ans * 2 + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question1009 question = new Question1009();
        System.out.println(question.bitwiseComplement(0));
        System.out.println(question.bitwiseComplement(5));
        System.out.println(question.bitwiseComplement(7));
        System.out.println(question.bitwiseComplement(10));
    }
}
