package Easy;

public class Question38 {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        res.append('1');
        int index = 1;
        while (index < n) {
            // store former str and clear the builder
            String tmp = res.toString();
            res.setLength(0);
            // create next str
            char p = tmp.charAt(0);
            int count = 0;
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == p)
                    count++;
                else {
                    res.append(count);
                    res.append(p);
                    count = 1;
                    p = tmp.charAt(i);
                }
            }
            res.append(count);
            res.append(p);
            index++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question38().countAndSay(5));
    }
}
