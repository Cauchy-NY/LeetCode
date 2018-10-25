package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question93 {
    // 提速40%
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
//    // backtrack 太慢orz
//    public List<String> restoreIpAddresses(String s) {
//        List<String> res = new ArrayList<>();
//        backtrack(res, new ArrayList<>(), s);
//        return res;
//    }
//
//    private void backtrack(List<String> res, List<String> nums, String s) {
//        if (nums.size() > 4)
//            return;
//        if (s.equals("") && nums.size() == 4) {
//            if (!res.contains(toIpString(nums)))
//                res.add(toIpString(nums));
//        }
//        else {
//            for (int i = 1; i <= 3; i++) {
//                if (i <= s.length()) {
//                    String tmp = s.substring(0, i);
//                    if(tmp.length()>3 || tmp.length()==0 || (tmp.charAt(0)=='0' && tmp.length()>1) || Integer.parseInt(tmp)>255)
//                        continue;
//                    else {
//                        nums.add(s.substring(0, i));
//                        backtrack(res, nums, s.substring(i, s.length()));
//                        nums.remove(nums.size() - 1);
//                    }
//                }
//            }
//        }
//    }
//
//    private String toIpString(List<String> nums) {
//        StringBuilder sb = new StringBuilder();
//        for (String num: nums)
//            sb.append(num + ".");
//        return sb.toString().substring(0, sb.toString().length()-1);
//    }

    public static void main(String...args) {
        new Question93().restoreIpAddresses("25525511135");
    }
}
