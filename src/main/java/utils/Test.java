package utils;

import java.util.*;

public class Test implements Cloneable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int idx = in.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j <= str.length(); j++) {
                int tmp = Integer.parseInt(str.substring(i, j));
                queue.add(tmp);
                if (queue.size() > idx)
                    queue.poll();
            }
        }
        System.out.println(queue.poll());
    }
}
