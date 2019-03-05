package Design;

public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a'] == null)
                cur.children[c-'a'] = new TrieNode(c);
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     * */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length)
            return node.isWord;

        if (chs[k] != '.') {
            return node.children[chs[k]-'a'] != null && match(chs, k+1, node.children[chs[k]-'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i]))
                        return true;
                }
            }
        }
        return false;
    }

    class TrieNode {
        char val;
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];

        TrieNode(char c) {
            this.val = c;
        }
    }
}
