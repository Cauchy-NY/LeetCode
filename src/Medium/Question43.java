package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question43 {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0
                || num1.equals("0") || num2.equals("0"))
            return "0";
        List<String> midList = new ArrayList<>();
        for(int i = num1.length()-1; i >= 0; i--) {
            int k = num1.charAt(i) - '0';
            if (k == 0)
                midList.add("0");
            else {
                int carry = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = num2.length()-1; j >= 0; j--) {
                    int p = num2.charAt(j) - '0';
                    int tmp = k*p + carry;
                    carry = tmp / 10;
                    sb.append(tmp % 10);
                }
                if (carry > 0)
                    sb.append(carry);
                midList.add(sb.reverse().toString());
            }
        }
        return addAll(midList);
    }

    private String addAll(List<String> list) {
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            if (tmp.equals("0"))
                continue;
            for (int k = 0; k < i; k++)
                tmp += '0';
            res = add(res, tmp);
        }
        return res;
    }

    private String add(String a,String b){
        int carry = 0;  //记录进位数
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=(a.length() > b.length() ? a.length() : b.length()); i++) {
            int c =  (a.length()>=i ? a.charAt(a.length()-i)-'0' : 0)  //短的字符串数字高位用0补齐
                    + (b.length()>=i ? b.charAt(b.length()-i)-'0' : 0)
                    + carry;
            sb.append(c % 10); //当前位拼接到字符串
            carry = c / 10;    //进位留到下一次运算
        }
        if(carry>0)
            sb.append(carry); //最后一次运算若有进位，拼接到字符串
        return sb.reverse().toString();
    }
}
