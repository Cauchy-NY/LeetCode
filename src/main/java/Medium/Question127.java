package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int distance = 1;

        while (!visited.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String word: visited) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            temp.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            distance++;
            if (temp.size() == 0)
                return 0;

            visited = temp;
        }

        return distance;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        new Question127().ladderLength("hit", "cog", new ArrayList<>());
    }
}
