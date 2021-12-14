package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int curFirst = 0, curSecond = 0;
        List<int[]> list = new ArrayList<>();
        while (curFirst < firstList.length && curSecond < secondList.length) {
            int[] first = firstList[curFirst];
            int[] second = secondList[curSecond];
            if (first[1] < second[0]) {
                curFirst++;
                continue;
            }
            if (first[0] > second[1]) {
                curSecond++;
                continue;
            }
            list.add(merge(first, second));
            if (first[1] > second[1]) {
                curSecond++;
            } else {
                curFirst++;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int[] merge(int[] first, int[] second) {
        if (first[0] < second[0]) {
            if (first[1] > second[1]) {
                return second;
            } else {
                return new int[]{second[0], first[1]};
            }
        } else {
            if (first[1] < second[1]) {
                return first;
            } else {
                return new int[]{first[0], second[1]};
            }
        }
    }

    private void printRes(int[][] res) {
        for (int[] row : res) {
            System.out.println("[" + row[0] + ", " + row[1] + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Question986 question = new Question986();
        int[][] res = question.intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
        );
        question.printRes(res);

        res = question.intervalIntersection(
                new int[][]{{1, 3}, {5, 9}},
                new int[][]{}
        );
        question.printRes(res);

        res = question.intervalIntersection(
                new int[][]{},
                new int[][]{{4, 8}, {10, 12}}
        );
        question.printRes(res);

        res = question.intervalIntersection(
                new int[][]{{1, 7}},
                new int[][]{{3, 10}}
        );
        question.printRes(res);

        res = question.intervalIntersection(
                new int[][]{{3, 5}, {9, 20}},
                new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}}
        );
        question.printRes(res);
    }
}
