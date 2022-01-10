package test;

import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        if (m == 0 || n == 0) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[m][n];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = in.nextInt();
            }
        }

        Map<Integer, Set<Integer>> reached = new HashMap<>();
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!reached.containsKey(i) || !reached.get(i).contains(j)) {
                    if (map[i][j] == 1) {
                        count++;
                        dfs(reached, map, i, j);
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(Map<Integer, Set<Integer>> reached, int[][] map, int x, int y) {
        if (reached.containsKey(x) && reached.get(x).contains(y)) {
            return;
        }
        if (map[x][y] == 1) {
            if (!reached.containsKey(x)) {
                reached.put(x, new HashSet<>());
            }
            reached.get(x).add(y);

            if (x - 1 >= 0) {
                dfs(reached, map, x - 1, y);
            }
            if (y - 1 >= 0) {
                dfs(reached, map, x, y - 1);
            }
            if (x + 1 < map.length) {
                dfs(reached, map, x + 1, y);
            }
            if (y + 1 < map[0].length) {
                dfs(reached, map, x, y + 1);
            }
        }
    }
}

/*
题目描述
琼斯先生有一块土地，他将这块土地分成大小相等的MxN块，并决定在这些土地上种花，但作为一个农场主，光种花是不行的，琼斯先生还需要在这块土地上种植不同的农作物。给定非空的二维数组（数组元素为1或0）来表示琼斯先生的决定，1代表种植花卉，0代表种植其他农作物。相邻为1的土地块形成一个“花坪”，现在请你计算琼斯先生共有多少种不同形状的“花坪”。
要求：“花坪”可以通过旋转变成另一个“花坪”，也就是说，如果两个“花坪”可以通过旋转重合，这两个“花坪”应被视为同一种“花坪”。

输入描述
第一行输入两个整数M，N（ 图片.png）代表该土地的形状大小。接下来M行，每行输入N个数字(0或1)，代表每块土地种植的植物。

输出描述
输出该土地中“花坪”的种类数。

样例输入
4 5
1 0 0 0 0
1 1 0 0 0
0 0 0 0 1
0 0 0 1 1

样例输出
1
(样例解释：左上角的形状可以通过旋转180度和右下角形状重合，因此算作1种花坪。)

注释
输入样例二
1 5
1 0 1 1 1

输出样例二
2
(样例解释：左边的“1”组成的形状为一种花坪，右边的“1 1 1”组成的形状为一种花坪，共2种花坪)
* */
