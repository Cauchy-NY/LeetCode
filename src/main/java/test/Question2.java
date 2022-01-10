package test;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int len = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                len += 2;
            } else {
                len = 2 * len - 1;
            }
        }

        char[][] ans = new char[len][len];
        for (char[] row : ans) {
            Arrays.fill(row, '.');
        }

        int cur = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                cur += 2;
                int start = (len - cur) / 2;
                int end = start + cur - 1;
                ans[start][start] = ans[start][end] = ans[end][start] = ans[end][end] = '+';
                for (int j = 1; j < cur - 1; j++) {
                    ans[start][start + j] = ans[end][start + j] = '-';
                    ans[start + j][end] = ans[start + j][start] = '|';
                }
            } else {
                cur = 2 * cur - 1;
                int mid = len / 2;
                int up = (len - cur) / 2, down = up + cur - 1;
                ans[up][mid] = '^';
                ans[down][mid] = 'V';
                ans[mid][up] = '<';
                ans[mid][down] = '>';
                for (int j = 1; j < mid - up; j++) {
                    ans[up + j][mid + j] = ans[down - j][mid - j] = '\\';
                    ans[mid - j][up + j] = ans[mid + j][down - j] = '/';
                }
                ans[(up+mid)/2][(up+mid)/2] = ans[(down+mid)/2][(up+mid)/2] = ans[(up+mid)/2][(down+mid)/2] = ans[(down+mid)/2][(down+mid)/2] = '+';
            }
        }

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}

/*
题目描述
有一种简易的万花筒，其形状是一个正方形套菱形套正方形套菱形套正方形……。现在，告诉你万花筒的阶级n，请你输出这个万花筒的样子。

输入描述
输入一个整数n（n<19）。

输出描述
输出对应的万花筒图案。

样例输入
4

样例输出
......^......
...../.\.....
..../...\....
...+-----+...
../|..^..|\..
./.|.+-+.|.\.
<..|<|.|>|..>
.\.|.+-+.|./.
..\|..V..|/..
...+-----+...
....\.../....
.....\./.....
......V......

注释
输入样例二
1
输出样例二
+-+
|.|
+-+
* */
