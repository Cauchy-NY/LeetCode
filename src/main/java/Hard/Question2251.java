package Hard;

import java.util.Arrays;

public class Question2251 {

    // TLE
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Arrays.sort(flowers, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ret = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            for (int[] duration : flowers) {
                if (duration[0] > person) {
                    break;
                }
                if (duration[1] >= person) {
                    ret[i]++;
                }
            }
        }
        return ret;
    }

    // 开花数减去凋落数
    public int[] fullBloomFlowers2(int[][] flowers, int[] persons) {
        int[] starts = Arrays.stream(flowers).mapToInt(f -> f[0]).sorted().toArray();
        int[] ends = Arrays.stream(flowers).mapToInt(f -> f[1]).sorted().toArray();
        return Arrays.stream(persons).map(p -> lowerBound(starts, p + 1) - lowerBound(ends, p)).toArray();
    }

    int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Question2251 question = new Question2251();
        Arrays.stream(question.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11}))
            .forEach(System.out::println);
    }
}
