package Medium;

import util.WordDictionary;

public class Question211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // -> false
        wordDictionary.search("bad"); // -> true
        wordDictionary.search(".ad"); // -> true
        wordDictionary.search("b.."); // -> true
    }
}
