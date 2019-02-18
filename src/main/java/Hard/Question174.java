package Hard;

public class Question174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;

        int m = dungeon.length, n = dungeon[0].length;
        int[][] hp = new int[m][n];

        hp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        for (int i = m - 2; i >= 0; i--)
            hp[i][n-1] = Math.max(hp[i+1][n-1] - dungeon[i][n-1], 1);
        for (int j = n - 2; j >= 0; j--)
            hp[m-1][j] = Math.max(hp[m-1][j+1] - dungeon[m-1][j], 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 如果 hp[i+1][j] - dungeon[i][j] < 1 说明房间有血瓶，剩余血量为1，保证不死即可
                int down = Math.max(hp[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                hp[i][j] = Math.min(right, down);  // 找出需要最少hp的方向
            }
        }

        return hp[0][0];
    }
}
