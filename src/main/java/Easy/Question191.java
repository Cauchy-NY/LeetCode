package Easy;

public class Question191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1')
                count++;
        }
        return count;
    }

    // TLE
    public int hammingWeight_2(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // java中转二进制字符串是无符号的
        System.out.println(Integer.toBinaryString(3));
        System.out.println(new Question191().hammingWeight(11));
    }
}
