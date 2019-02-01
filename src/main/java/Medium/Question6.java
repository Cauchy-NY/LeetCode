package Medium;

public class Question6 {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) {
            return s;
        }
        else {
            int n = numRows;
            StringBuilder sb = new StringBuilder();
            // first line
            for(int i = 0; i < s.length(); i+=2*n-2) {
                sb.append(s.charAt(i));
            }
            //middle
            for(int i = 2; i < n; i++) {
                int pos = i-1;
                sb.append(s.charAt(pos));
                int flag = 0;
                pos += (2*n-2) - (i-1)*2;
                while(pos < s.length()) {
                    if(flag == 0) {
                        sb.append(s.charAt(pos));
                        pos += (i-1)*2;
                        flag = 1;
                    }
                    else {
                        sb.append(s.charAt(pos));
                        pos += (2*n-2) - (i-1)*2;
                        flag = 0;
                    }
                }
            }
            // last line
            for(int i = n-1; i < s.length(); i+=2*n-2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
