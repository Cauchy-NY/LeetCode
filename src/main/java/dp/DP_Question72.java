package dp;

public class DP_Question72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.equals("")) {
            return word2.length();
        }
        if (word2 == null || word2.equals("")) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DP_Question72 question = new DP_Question72();
        System.out.println(question.minDistance("horse", "ros"));
        System.out.println(question.minDistance("intention", "execution"));
    }
}
