package Easy;

import java.util.Arrays;

public class Question14 {
    public String longestCommonPrefix(String[] strs) {
//        if(strs.length == 0 || strs == null)
//            return "";
//        String result = strs[0];
//        int index = 1;
//        while(index < strs.length) {
//            result = longestCommonPrefixBetweenTwoStrs(result, strs[index]);
//            if(result.equals("") || result.length() == 1) {
//                result = "";
//                break;
//            }
//            index++;
//        }
//        return result;
        StringBuilder result = new StringBuilder();
        if (strs!= null && strs.length > 0) {
            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }

//    private String longestCommonPrefixBetweenTwoStrs(String str1, String str2) {
//        String result = "";
//        // dp
//        int len1 = str1.length();
//        int len2 = str2.length();
//        int pos = 0;  // 记录最长公共子串结束位置
//        int maxLen = 0;  // 记录最长公共子串长度
//        int c[][] = new int[len1+1][len2+1];
//        for (int i = 0; i <= len1; i++) {
//            for( int j = 0; j <= len2; j++) {
//                if(i == 0 || j == 0) {
//                    c[i][j] = 0;
//                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
//                    c[i][j] = c[i-1][j-1] + 1;
//                    if(c[i][j] > maxLen) {
//                        maxLen = c[i][j];
//                        pos = j;
//                    }
//                } else {
//                    c[i][j] = 0;
//                }
//            }
//        }
//        if(maxLen > 0) {
//            result = str2.substring(pos-maxLen, pos);
//        }
//        return result;
//    }
}
