package Medium;

public class Question64 {
    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++)
            sum[i][0] = sum[i-1][0] + grid[i][0];
        for (int j = 1; j < grid[0].length; j++)
            sum[0][j] = sum[0][j-1] + grid[0][j];
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                sum[i][j] = Integer.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
        return sum[grid.length-1][grid[0].length-1];
    }
//    // backtrack, TLE orz
//    public int minPathSum(int[][] grid) {
//        if (grid == null)
//            return 0;
//        List<Integer> pathLenList = new ArrayList<>();
//        backtrack(pathLenList, grid, 0, 0, 0);
//        pathLenList.sort((a, b) -> Integer.compare(a, b));
//        return pathLenList.get(0);
//    }
//
//    private void backtrack(List<Integer> pathLenList, int[][] grid,
//                           int i, int j, int pathLen) {
//        if (i == grid.length-1 && j == grid[0].length-1)
//            pathLenList.add(pathLen+grid[i][j]);
//        else {
//            if (i != grid.length-1)
//                backtrack(pathLenList, grid, i+1, j, pathLen+grid[i][j]);
//            if (j != grid[0].length-1)
//                backtrack(pathLenList, grid, i, j+1, pathLen+grid[i][j]);
//        }
//    }

    public static void main(String...args) {
        new Question64().minPathSum(new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        });
    }
}
