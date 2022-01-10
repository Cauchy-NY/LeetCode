package test;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Date> times = new ArrayList<>();
        times.add(new Date(2019, 1, 1, 0, 0));
        Date end = new Date(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        for (int i = 0; i < 2 * n; i++) {
            times.add(new Date(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }
        times.add(end);

        long maxTime = 0;
        for (int i = 0; i < times.size(); i += 2) {
            maxTime = Math.max(maxTime, times.get(i + 1).getMinutes() - times.get(i).getMinutes());
        }
        System.out.println(maxTime);
    }
}

class Date {
    int year;
    int month;
    int day;
    int hour;
    int minute;

    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getMinutes() {
        int d = getMonthDay(month) + day;
        int h = d * 24 + hour;
        int m = h * 60 + minute;
        return m;
    }

    int getMonthDay(int m) {
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 0; i < m - 1; i++) {
            res += months[i];
        }
        return res;
    }
}

/*
题目描述
小明参加了系里的学术新星计划，最近他有一个不成熟的idea，并打算找他的导师进行讨论。
现在是2019.1.1的0:00，在Google Calendar上小明看到他的导师有N个时间段已被占用（被占用的时间段之间互不重叠），以及导师将会在Y年M月D日H时m分出差。小明想知道，在导师出差前，他能预约到的最长讨论时间段为多少分钟？
注意：需要考虑跨日、跨月的情况。为了简便，所有的测试用例的时间均在2019年内。

输入描述
第一行六个整数，依次为N, Y, M, D, H, m，分别表示被占用时间段数目N和导师出差的时间（Y年M月D日H时m分）。其中H是24小时制，m是60分钟制。
接下来N行，每行十个整数, s1~s5，t1~t5，表示s1年s2月s3日s4时s5分到t1年t2月t3日t4时t5分导师在忙。（所有被占用的时间段按时间的先后有序输入，不考虑无序的情况）

输出描述
小明能预约到的最长讨论时间段的分钟数。

样例输入
1 2019 1 2 0 0
2019 1 1 3 0 2019 1 1 17 0

样例输出
420
* */
