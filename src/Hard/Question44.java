package Hard;

public class Question44 {
    public boolean isMatch(String s, String p) {
        int row = p.length() + 1;
        int col = s.length() + 1;
        boolean[][] dp = new boolean[row][col];
        // init
        dp[0][0] = true;
        // 模式串为空
        for(int i=1;i<col;i++)
            dp[0][i] = false;
        // 待匹配串为空，只有模式串全为*才能匹配
        for(int j=1;j<row;j++) {
            if(p.charAt(j-1)=='*')
                dp[j][0] = dp[j-1][0];
            else
                dp[j][0] = false;
        }
        // dp
        for(int i=1;i<col;i++) {
            for (int j = 1; j < row; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 要么是上面是true 要么是左边是true
                    // 如果上面是true，此时*当空串使，如果左边是true，那么此时*当一个字符使
                    if (dp[j - 1][i] || dp[j][i - 1])
                        dp[j][i] = true;
                    else
                        dp[j][i] = false;
                } else {
                    // 如果不为*的话，首先左上角的位置要是true，如果不是的话，s和p都增加一个字符也不会匹配
                    // 同时s和p增加的字符要相同或者p是？
                    if (dp[j - 1][i - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'))
                        dp[j][i] = true;
                    else
                        dp[j][i] = false;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
