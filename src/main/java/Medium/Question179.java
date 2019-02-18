package Medium;

import java.util.Arrays;

public class Question179 {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";

        String[] s_num = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);

        // "9"+"31"="931", "31"+"9"="319"
        Arrays.sort(s_num, (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        });

        // 处理一串0的情况
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();
    }
}
