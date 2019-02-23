package Hard;

import java.util.*;

public class Question212 {
    // 评论区dalao的答案，灵活运用前缀树
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    //----------------------------------------------------------------------

    // wyl的暴力美学，慢到爆炸的答案
    public List<String> findWords_2(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();

        if (words == null || words.length == 0 || board == null
                || board.length == 0 || board[0].length == 0)
            return new ArrayList<>(res);

        Set<String> set = new HashSet<>(Arrays.asList(words));
        words = new String[set.size()];
        words = set.toArray(words);


        for (String word: words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0))
                        backtrack(res, board, word, 0, i, j);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void backtrack(Set<String> res, char[][] board, String word,
                           int index, int x, int y) {
        if (word.charAt(index) == board[x][y]) {
            index++;
            if (index == word.length()) {
                res.add(word);
                return;
            }

            char tmp = board[x][y];
            board[x][y] = ' ';

            if (x > 0)
                backtrack(res, board, word, index, x-1, y);

            if (x < board.length-1)
                backtrack(res, board, word, index, x+1, y);

            if (y > 0)
                backtrack(res, board, word, index, x, y-1);

            if (y < board[0].length-1)
                backtrack(res, board, word, index, x, y+1);

            board[x][y] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        new Question212().findWords(board, words);
    }
}
