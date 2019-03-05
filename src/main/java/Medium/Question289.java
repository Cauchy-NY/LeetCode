package Medium;

public class Question289 {
    /**
     * 这个原地算法的核心想法和计算岛屿面积的那道题一样，将所有遍历搜索过的改一下状态
     * 新的状态信息，将可以表示包括之前的现在信息和将来的信息
     * 0 和 1 可以表示当前初始和死亡，0-3 则可以表示 00 01 10 11 四种情况，即
     * 00  dead (next) <- dead (current)
     * 01  dead (next) <- live (current)
     * 10  live (next) <- dead (current)
     * 11  live (next) <- live (current)
     * board[i][j] & 1 即为当前情况，这四种情况右移一位即为将来情况
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3)
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11

                if (board[i][j] == 0 && lives == 3)
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 01
            }
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] >>= 1;  // Get the 2nd state.
    }

    private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
