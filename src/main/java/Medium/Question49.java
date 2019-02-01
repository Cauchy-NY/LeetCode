package Medium;

import java.util.*;

public class Question49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());

//        第一时间其实意识到了hash，但是不想用结果速度慢的一批 orz
//        List<List<String>> res = new ArrayList<>();
//        List<String> type = new ArrayList<>();
//        for (String str: strs) {
//            boolean isArranged = false;
//            char[] charList = str.toCharArray();
//            Arrays.sort(charList);
//            String tmp = String.valueOf(charList);
//            for (int i = 0; i < type.size(); i++) {
//                if (type.get(i).equals(tmp)) {
//                    res.get(i).add(str);
//                    isArranged = true;
//                }
//            }
//            if (!isArranged) {
//                type.add(tmp);
//                res.add(new ArrayList<>());
//                res.get(res.size()-1).add(str);
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        new Question49().groupAnagrams(new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        });
    }
}
