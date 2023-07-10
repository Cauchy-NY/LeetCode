package Hard;

public class Question32 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - dp[i - 1] - 1 >= 0) {
                    if (s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i] >= 0) {
                            dp[i] += dp[i - dp[i]];
                        }
                    }
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
