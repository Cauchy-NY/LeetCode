package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y && ++cnt >= 0) continue;
            list.add(Math.atan2(b - y, a - x) + pi);
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
//    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
//        if (points.size() <= 1)
//            return 1;
//
//        int self = 0;
//        List<List<Integer>> vectors = new ArrayList<>();
//        for (int i = 0; i < points.size(); i++) {
//            int x = points.get(i).get(0) - location.get(0);
//            int y = points.get(i).get(1) - location.get(1);
//            if (x == 0 && y == 0) {
//                self++;
//            } else {
//                vectors.add(Arrays.asList(x, y));
//            }
//        }
//        double angleInPi = angle / 180.0 * Math.PI;
//
//        Collections.sort(vectors, (a, b) -> {
//            double diff = calculateAngle(a.get(0), a.get(1), 1, 0) - calculateAngle(b.get(0), b.get(1), 1, 0);
//            return diff == 0.0 ? 0 : diff > 0 ? 1 : -1;
//        });
//        int first = 0, second = 1, max = 0;
//        while (true) {
//            double tmpAngle = calculateAngle(vectors.get(first).get(0), vectors.get(first).get(1),
//                    vectors.get(second).get(0), vectors.get(second).get(1));
//            if (tmpAngle <= angleInPi) {
//                second = (second + 1) % vectors.size();
//                if (second == first) {
//                    max = vectors.size();
//                    break;
//                }
//            } else {
//                max = Math.max(max, second - first);
//                if (first == vectors.size())
//                    break;
//            }
//        }
//        return max + self;
//    }

    private double calculateAngle(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2)
            return 0.0;
        return Math.acos((x1 * x2 + y1 * y2) / (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2)));
    }

    public static void main(String[] args) {
        Question1610 question = new Question1610();

        System.out.println(question.calculateAngle(2, 2, 1, 0));
        System.out.println(question.calculateAngle(1, 1, 1, 0));
        System.out.println(question.calculateAngle(1, 0, 1, 0));
        System.out.println(question.calculateAngle(1, 1, 1, 1));

        System.out.println(question.visiblePoints(
                Arrays.asList(
                        Arrays.asList(2, 1),
                        Arrays.asList(2, 2),
                        Arrays.asList(3, 3)
                ),
                90,
                Arrays.asList(1, 1)
        ));

        System.out.println(question.visiblePoints(
                Arrays.asList(
                        Arrays.asList(2, 1),
                        Arrays.asList(2, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(1, 1)
                ),
                90,
                Arrays.asList(1, 1)
        ));

        System.out.println(question.visiblePoints(
                Arrays.asList(
                        Arrays.asList(1, 0),
                        Arrays.asList(2, 1)
                ),
                13,
                Arrays.asList(1, 1)
        ));

        System.out.println(question.visiblePoints(
                Arrays.asList(
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2),
                        Arrays.asList(2, 1),
                        Arrays.asList(1, 2)
                ),
                0,
                Arrays.asList(1, 1)
        ));

        System.out.println(question.visiblePoints(
                Arrays.asList(
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2),
                        Arrays.asList(3, 3),
                        Arrays.asList(4, 4),
                        Arrays.asList(2, 1),
                        Arrays.asList(1, 2)
                ),
                0,
                Arrays.asList(1, 1)
        ));
    }
}
