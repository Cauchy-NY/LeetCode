package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question472 {
// 暴力爆栈
//    public List<String> findAllConcatenatedWordsInADict(String[] words) {
//        List<String> ans = new ArrayList<>();
//        if (words.length < 2) return ans;
//
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//        for (int i = 1; i < words.length; i++) {
//            String word = words[i];
//            if (isConcatenatedWords(words, i, word)) {
//                ans.add(word);
//            }
//        }
//        return ans;
//    }
//
//    private boolean isConcatenatedWords(String[] words, int end, String word) {
//        if (word.equals(""))
//            return true;
//        for (int i = 0; i < end; i++) {
//            if (word.startsWith(words[i])) {
//                String sub = word.substring(word.indexOf(words[i]) + words[i].length());
//                int newEnd = 0;
//                while (newEnd < words.length && sub.length() >= words[newEnd].length()) newEnd++;
//                if (isConcatenatedWords(words, end, sub))
//                    return true;
//            }
//        }
//        return false;
//    }

    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public boolean dfs(String word, int start) {
        if (word.length() == start) {
            return true;
        }
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (dfs(word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        Question472 question = new Question472();
        output(question.findAllConcatenatedWordsInADict(new String[] {"cat","dog","catdog"}));
        output(question.findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }

    private static void output(List<String> ans) {
        ans.forEach(str -> System.out.print(str + " "));
        System.out.println();
    }
}
