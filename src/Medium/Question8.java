package Medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question8 {
//    public int myAtoi(String str) {
//        if(str.equals("") || str == null || str.charAt(0) == '.')
//            return 0;
//
//        int begin = 0;
//        while(str.charAt(begin) == ' ') {
//            begin++;
//            if(begin == str.length())
//                return 0;
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = begin; i < str.length() && str.charAt(i) != ' ' && str.charAt(i) != '.'; i++)
//            sb.append(str.charAt(i));
//
////        Pattern p = Pattern.compile("-?\\d+");
////        Matcher m = p.matcher(sb.toString());
////
////        if(m.matches()) {
////            int result = 0;
////            boolean isMinus = false;
////            if(sb.toString().charAt(0) == '-')
////                isMinus = true;
////
////            try {
////                result = Integer.parseInt(sb.toString());
////            } catch (Exception e) {
////                if(isMinus)
////                    return Integer.MIN_VALUE;
////                else
////                    return Integer.MAX_VALUE;
////            }
////            return result;
////        }
////        else
////            return 0;
//
//        String s = sb.toString();
//
//        if(s == null || s.equals("-"))
//            return 0;
//
//        for(int i = 0; i < s.length(); i++) {
//            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '-' && s.charAt(i) != '+') {
//                return 0;
//            }
//        }
//
//        int result = 0;
//        boolean isMinus = false;
//        if(s.charAt(0) == '-')
//            isMinus = true;
//
//        try {
//            result = Integer.parseInt(s);
//        } catch (Exception e) {
//            if(isMinus)
//                return Integer.MIN_VALUE;
//            else
//                return Integer.MAX_VALUE;
//        }
//        return result;
//    }

    public int myAtoi(String str) {
        int strLen = str.length();
        if (str == "")
            return 0;
        int i = 0;

        while (i < strLen){
            if(str.charAt(i) == ' ')
                i++;
            else
                break;
        }
        if (i == strLen)
            return 0;
        int signal = 1;
        if (str.charAt(i) == '+'){
            signal = 1;
            i++;
        }
        else if (str.charAt(i) == '-'){
            signal = -1;
            i++;
        }
        long res = 0;
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        while (i < strLen){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                //是数字则乘以权值并相加
                res = res*10 + signal*(str.charAt(i) - '0');
            }
            else
                return (int)res;
            if (res > maxInt || res < minInt)
                return res>0 ? maxInt: minInt;
            i++;
        }
        return (int)res;
    }
}
