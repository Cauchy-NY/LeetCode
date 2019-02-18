package Medium;

import java.util.*;

public class Question187 {
    // 编写一个函数来查找 DNA 分子中所有出现超过一次的10个字母长的序列(子串)
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}
