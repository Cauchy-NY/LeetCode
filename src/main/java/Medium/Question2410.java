package Medium;

import java.util.Arrays;

public class Question2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, match = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                match++;
            } else {
                j++;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Question2410 question = new Question2410();
        System.out.println(question.matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
        System.out.println(question.matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10}));
    }
}
