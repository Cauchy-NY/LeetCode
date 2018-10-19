package Medium;

public class Question79 {
    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length())
            return false;
        if (word.length() == 0)
            return true;
        boolean isFinded = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isFinded = isFinded || findWord(board, word, i, j, 0);
                }
            }
        }
        return isFinded;
    }

    private boolean findWord(char[][] board, String word, int i, int j, int count) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;
        if (board[i][j] != word.charAt(count))
            return false;
        else {
            count++;
            if (count == word.length())
                return true;

            board[i][j] ^= 256;  // 解决重复使用字符问题
            boolean isFinded = findWord(board, word, i-1, j, count)
                    || findWord(board, word, i+1, j, count)
                    || findWord(board, word, i, j-1, count)
                    || findWord(board, word, i, j+1, count);
            board[i][j] ^= 256;
            return isFinded;
        }
    }

    public static void main(String...args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        System.out.println(new Question79().exist(board, "ABCB"));
    }
}
