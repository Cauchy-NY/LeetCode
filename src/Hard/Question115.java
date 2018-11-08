package Hard;

public class Question115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        if (t.length() == 0)
            return s.length();

        int[][] dp = new int[s.length()+1][t.length()+1];
        // i和j都从1开始，且j不能大于i，因为匹配的长度至少为1开始，j大于i无意义
        for (int i = 0; i <= s.length(); ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length() && j <= i; ++j) {
                if (i == j) {
                    if (s.substring(0, i).equals(t.substring(0, j)))
                        dp[i][j] = 1;
                }
                else {
                    if (s.charAt(i - 1) != t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    StringBuilder sb = new StringBuilder();
}
