package utils;

import java.util.Arrays;

public class Output {
    public static <T> void outputInLine(T[] res) {
        Arrays.stream(res).forEach(d -> System.out.print(d + " "));
        System.out.println();
    }
}
