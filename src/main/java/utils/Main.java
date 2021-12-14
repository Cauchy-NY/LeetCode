package utils;

import java.util.*;

public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        StringBuilder sb = new StringBuilder();
        int[] pigs = new int[m+1];
        pigs[0] = 2;
        pigs[1] = 2;
        pigs[2] = 3;
        if(m >= 3) {
            for(int i = 3; i < m; i++)
                pigs[i] = pigs[i-2] + pigs[i-3];
        }
        sb.append(pigs[m]+",");

        int yearIdx = 0;
        for (int i = 1; i < m; i++) {
            if (pigs[i] > m) {
                yearIdx = i;
                break;
            }
        }

        if (yearIdx == 3) sb.append(2020+",");
        else if (yearIdx > 3 && yearIdx % 2 == 0) sb.append((3*yearIdx+2011)+",");
        else if (yearIdx > 3 && yearIdx % 2 != 0) sb.append((3*yearIdx+2010)+",");


        // find index
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= m; i++)
            queue.offer(reverse(pigs[i]));
        while (queue.size() > k)
            queue.poll();
        int max = queue.poll();
        for (int i = 1; i <= m; i++) {
            if (reverse(pigs[i]) == max) {
                sb.append(i);
                break;
            }
        }

        return sb.toString();
    }

    static int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res *= 10;
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        System.out.println(calculate(m, k));
    }
}