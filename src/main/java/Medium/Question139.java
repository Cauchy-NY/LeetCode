package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question139 {

    Set<String> map = new HashSet();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        if(map.contains(s))
            return false;
        for(String word : wordDict){
            if(s.startsWith(word))
                if(wordBreak(s.substring(word.length()), wordDict))
                    return true;
        }
        map.add(s);
        return false;
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.equals(""))
//            return true;
//
//        boolean isWordBreak = false;
//        for (String word: wordDict) {
//            if (s.startsWith(word)) {
//                isWordBreak |= wordBreak(s.substring(word.length()), wordDict);
//            }
//        }
//
//        return isWordBreak;
//    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        new Question139().wordBreak("leetcode", wordDict);
    }
}
