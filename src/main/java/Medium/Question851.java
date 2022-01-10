package Medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] richerCase : richer) {
            if (map.containsKey(richerCase[1])) {
                List<Integer> richerPerson = map.get(richerCase[1]);
                richerPerson.add(richerCase[0]);
            } else {
                List<Integer> richerPerson = new ArrayList<>();
                richerPerson.add(richerCase[0]);
                map.put(richerCase[1], richerPerson);
            }
        }

        int[] ret = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            ret[i] = -1;
        }
        for (int i = 0; i < quiet.length; i++) {
            ret[i] = findQuietest(map, quiet, ret, i);
        }
        return ret;
    }

    private int findQuietest(Map<Integer, List<Integer>> map, int[] quiet, int[] ret, int person) {
        if (!map.containsKey(person))
            return person;
        if (ret[person] != -1)
            return ret[person];

        List<Integer> richerPerson = map.get(person);
        int quietest = person;
        for (Integer personIdx : richerPerson) {
            int tmp = findQuietest(map, quiet, ret, personIdx);
            if (quiet[tmp] < quiet[quietest]) quietest = tmp;
        }
        return quietest;
    }

    public static void main(String[] args) {
        Question851 question = new Question851();
        output(question.loudAndRich(
                new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}},
                new int[]{3, 2, 5, 4, 6, 1, 7, 0}
        ));
        output(question.loudAndRich(
                new int[][]{},
                new int[]{0}
        ));
    }

    private static void output(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
