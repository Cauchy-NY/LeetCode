package Hard;

public class Question10 {
    public boolean isMatch(String s, String p) {
//        int i = 0, j = 0;
//        for(; i < p.length() && j < s.length(); i++, j++) {
//            if(p.charAt(i) != '.' && p.charAt(i) != '*') {
//                if(p.charAt(i) != s.charAt(j)) {
//                    if(i < p.length()-1) {
//                        if(p.charAt(i+1) == '*') {
//                            i++;
//                            j--;
//                            continue;
//                        }
//                    }
//                    else
//                        return false;
//                }
//            }
//            if(p.charAt(i) == '*') {
//                if(p.charAt(i-1) == '.') {
//                    if(i != p.length()-1) {
//                        i++;
//                        while(s.charAt(j) != p.charAt(i)) {
//                            j++;
//                            if(j == s.length())
//                                return false;
//                        }
//                    }
//                    else {
//                        return true;
//                    }
//                    continue;
//                }
//                while(s.charAt(j) == p.charAt(i-1)) {
//                    j++;
//                    if(j == s.length())
//                        break;
//                }
//                j--;
//                if(i < p.length()-1) {
//                    if(p.charAt(i-1) == p.charAt(i+1))
//                        i++;
//                }
//            }
//        }
//        if(i != p.length() || j != s.length())
//            return false;
//        return true;

        int sLen = s.length();
        int pLen = p.length();
        if(pLen == 0) return sLen == 0;
        if(pLen == 1){
            if(p.equals(s) || p.equals(".") && s.length() == 1) return true;
            else return false;
        }
        if(p.charAt(pLen-1) != '*' && p.charAt(pLen-1) != '.' && !s.contains(p.substring(pLen-1))) return false;
        if(p.charAt(1) == '*'){
            //p的下个字符是'*'，如果p和s当前字符相同或p当前字符是'.'，则一直往右移动
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' )){
                if(isMatch(s,p.substring(2))) return true;
                s = s.substring(1);
            }
            return isMatch(s,p.substring(2));
        }
        else{
            //p的下个字符不是'*'，如果p和s当前字符相同或p当前字符是'.'，则p和s往右移动一个字符
            if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1),p.substring(1));
            }
            return false;
        }
    }
}
