package Medium;

public class Question2079 {
    public static int wateringPlants(int[] plants, int capacity) {
        int remain = capacity, step = 0;
        for (int i = 0; i < plants.length; i++) {
            if (remain >= plants[i]) {
                remain -= plants[i];
                step++;
            } else {
                remain = capacity - plants[i];
                step += 2 * i + 1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{2, 2, 3, 3}, 5));
        System.out.println(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        System.out.println(wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
        System.out.println(wateringPlants(new int[]{3, 2, 4, 2, 1}, 6));
    }
}
