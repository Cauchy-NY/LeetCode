package Easy;

import java.util.Arrays;

public class Question1446 {
    public int maxPower(String s) {
        int count = 0;
        int tmpCnt = 0;
        char before = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == before) {
                tmpCnt++;
            } else {
                count= Math.max(tmpCnt, count);
                before = cur;
                tmpCnt = 1;
            }
        }
        count= Math.max(tmpCnt, count);
        return count;
    }

    public static void main(String[] args) {
        Question1446 question = new Question1446();
        System.out.println(question.maxPower("j"));
        System.out.println(question.maxPower("leetcode"));
        System.out.println(question.maxPower("abbcccddddeeeeedcba"));
        System.out.println(question.maxPower("triplepillooooow"));
        System.out.println(question.maxPower("hooraaaaaaaaaaay"));
        System.out.println(question.maxPower("tourist"));
    }
}
