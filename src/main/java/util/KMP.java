package util;

public class KMP {
    public static int kmp(String str, String pattern) {
        int i = 0;
        int j = 0;
        int[] next = getNextArray(pattern);
        while (i < str.length() && j < pattern.length()) {
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }

        if (j == pattern.length())
            return i - j;
        else
            return -1;
    }

    private static int[] getNextArray(String pattern) {
        int[] next = new int[pattern.length()];
        int i = 0, j = -1;
        next[0] = -1;

        while (i < pattern.length()-1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(kmp("asdasdk", "asdk"));
    }
}
