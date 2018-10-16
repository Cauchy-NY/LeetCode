package Medium;

public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
                else if (i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if (i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                else if (j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else {
                    if (obstacleGrid[i-1][j] != -1)
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    if (obstacleGrid[i][j-1] != -1)
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] > 0
                ? obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] : 0;
    }
}
