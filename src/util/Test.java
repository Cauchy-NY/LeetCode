package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher("n23");
        System.out.println(m.matches());

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString());
    }
}
