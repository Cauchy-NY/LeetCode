package Hard;

import java.util.ArrayList;
import java.util.List;

public class Question52 {

    private int res = 0;

    public int totalNQueens(int n) {
        char[][] nQueens = new char[n][n];
        // init
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                nQueens[i][j] = '.';
        // backtrack
        backtrack(nQueens, 0);
        return res;
    }

    // dfs
    private void backtrack(char[][] nQueens, int col) {
        if (col == nQueens.length)
            res++;
        else {
            for (int row = 0; row < nQueens.length; row++) {
                if(isvalid(nQueens, row, col)) {
                    nQueens[row][col] = 'Q';
                    backtrack(nQueens, col+1);
                    nQueens[row][col] = '.';
                }
            }
        }
    }

    private boolean isvalid(char[][] nQueens, int x, int y) {
        for(int i = 0; i < nQueens.length; i++) {
            for(int j = 0; j < y; j++) {
                if(nQueens[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }
}
