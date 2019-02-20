package Easy;

public class Question205 {
    // 基本想法，同构的两个单词间，字母间映射关系应该是一一对应的，没有一对多和多对一
    // 初始化两个长度为256的数组(ASCII有256个)
    // 1.title和paper是对应的，那么
    // 检查 map1['t'] == map2['p'] 是否成立，初始情况都为0，对应关系没有建立，显然成立
    // 再设立对应关系，设 map1['t'] == map2['p'] = 1，循环结束，对应均成立
    // 2.foo和bar不是对应的
    // map1['f'] == map2['b'] = 1
    // map1['o'] == map2['a'] = 2
    // map1['o']=2 != map2['r']=0，返回false，循环结束
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;
            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }
        return true;
    }
}
