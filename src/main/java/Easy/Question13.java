package Easy;

public class Question13 {
    public int romanToInt(String s) {
        int result = 0;
        if(s != null || s != "") {
            for(int i = 0; i < s.length(); i++) {
                int tmp = charToInt(s.charAt(i));
                boolean isMinus = false;
                for(int j = i+1; j < s.length(); j++) {
                    if(charToInt(s.charAt(j)) > tmp) {
                        result -= tmp;
                        isMinus = true;
                        break;
                    }
                }
                if(!isMinus)
                    result += tmp;
            }
        }
        return result;
    }

    private int charToInt(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
