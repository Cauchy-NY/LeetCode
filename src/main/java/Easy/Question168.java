package Easy;

public class Question168 {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n-- != 0) {
            res.insert(0, (char)(n%26 + 'A'));
            n /= 26;
        }
        return res.toString();
    }
}
