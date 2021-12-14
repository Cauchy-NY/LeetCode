package Easy;

import java.util.HashMap;
import java.util.Map;

public class Question2078 {

    public static int maxDistance(int[] colors) {
        if (colors.length <= 1)
            return 0;

        int maxDistance = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            if (!map.containsKey(colors[i])) {
                map.put(colors[i], i);
            }
            for (int color : map.keySet()) {
                if (color == colors[i])
                    continue;
                if ((i - map.get(color)) > maxDistance)
                    maxDistance = i - map.get(color);
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] colors1 = {1, 1, 1, 6, 1, 1, 1};
        int[] colors2 = {1, 8, 3, 8, 3};
        int[] colors3 = {0, 1};

        System.out.println(maxDistance(colors1));
        System.out.println(maxDistance(colors2));
        System.out.println(maxDistance(colors3));
    }
}
