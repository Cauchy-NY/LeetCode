package Easy;

public class Question28 {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length())
            return -1;
        if(needle.equals(""))
            return 0;
        for(int i = 0; i < haystack.length(); i++) {
            if((i + needle.length()) > haystack.length())
                return -1;
            int j = 0;
            for(; j < needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
            if(j == needle.length())
                return i;
        }
        return -1;
    }
}
