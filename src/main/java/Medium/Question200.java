package Medium;

import java.util.Stack;

public class Question200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0 ;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    combine(grid, i, j);
                }
            }
        }
        return count;
    }
    // 非递归
    private void combine(char[][] grid, int x, int y) {
        Stack<Integer> xs = new Stack<>();
        Stack<Integer> ys = new Stack<>();

        xs.push(x);
        ys.push(y);

        while (!xs.isEmpty()) {
            int tmpx = xs.pop();
            int tmpy = ys.pop();

            grid[tmpx][tmpy] = '2';

            if (tmpx < grid.length-1 && grid[tmpx+1][tmpy] == '1') {  // 向下
                xs.push(tmpx+1);
                ys.push(tmpy);
            }
            if (tmpy < grid[0].length-1 && grid[tmpx][tmpy+1] == '1') {  // 向右
                xs.push(tmpx);
                ys.push(tmpy+1);
            }
            if (tmpx > 0 && grid[tmpx-1][tmpy] == '1') {  // 向上
                xs.push(tmpx-1);
                ys.push(tmpy);
            }
            if (tmpy > 0 && grid[tmpx][tmpy-1] == '1') {  // 向左
                xs.push(tmpx);
                ys.push(tmpy-1);
            }
        }
    }

    // 递归
    private void combine_2(char[][] grid, int x, int y) {
        grid[x][y] = '2';

        if (x < grid.length-1 && grid[x+1][y] == '1')  // 向下
            combine(grid,x+1,y);

        if (y < grid[0].length-1 && grid[x][y+1] == '1')  // 向右
            combine(grid,x,y+1);

        if (x > 0 && grid[x-1][y] == '1')  // 向上
            combine(grid,x-1,y);

        if (y > 0 && grid[x][y-1] == '1')  // 向左
            combine(grid,x,y-1);
    }
}
