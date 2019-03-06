package Medium;

public class Question299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0)
                    cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0)
                    cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint_2(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length() && i < guess.length(); i++) {
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';

            if (s == g)
                bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
