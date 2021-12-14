package Easy;

import java.util.Arrays;

public class Question506 {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        Integer[] index = new Integer[score.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> score[b] - score[a]);
        res[index[0]] = "Gold Medal";
        if (score.length >= 2) res[index[1]] = "Silver Medal";
        if (score.length >= 3) res[index[2]] = "Bronze Medal";
        for (int i = 3; i < score.length; i++)
            res[index[i]] = String.valueOf(i + 1);
        return res;
    }

    public static void main(String[] args) {
        Question506 question = new Question506();
        utils.Output.outputInLine(question.findRelativeRanks(new int[]{10}));
        utils.Output.outputInLine(question.findRelativeRanks(new int[]{10, 3}));
        utils.Output.outputInLine(question.findRelativeRanks(new int[]{10, 3, 8, 9, 4}));
    }
}
