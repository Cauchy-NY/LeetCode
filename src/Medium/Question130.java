package Medium;

public class Question130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                backtrack(board, i, 0);
            if (board[i][board[0].length-1] == 'O')
                backtrack(board, i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                backtrack(board, 0, i);
            if (board[board.length-1][i] == 'O')
                backtrack(board, board.length-1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void backtrack(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return;
        if (board[i][j] == 'X' || board[i][j] =='*')
            return;

        board[i][j] = '*';

        backtrack(board, i+1, j);
        backtrack(board, i-1, j);
        backtrack(board, i, j+1);
        backtrack(board, i, j-1);
    }
}
