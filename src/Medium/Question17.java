package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question17 {
    public List<String> letterCombinations(String digits) {
        String[] phone =  {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.equals("") || digits == null)
            return result;
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, digits, phone, 0);
        Collections.sort(result);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String digits, String[] phone, int index) {
        if(sb.length() == digits.length())
            result.add(new String(sb));

        for(int i = index; i < digits.length(); i++) {
            String phonePos = phone[Character.getNumericValue(digits.charAt(i))] ;
            char[] cp = phonePos.toCharArray();

            for(char c: cp) {
                sb.append(c);
                backtrack(result, sb, digits, phone, i+1);
                sb.setLength(sb.length()-1);  // 将刚刚加入进去的字符丢弃。重新加入下一个字符并递归
            }
        }
    }
}
