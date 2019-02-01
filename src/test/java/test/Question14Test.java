package test;

import Easy.Question14;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question14Test {
    Question14 q = new Question14();

    @Test
    public void test1() {
        assertEquals("", q.longestCommonPrefix(new String[]{"a", "ca"}));
    }

    @Test
    public void test2() {
        assertEquals("", q.longestCommonPrefix(new String[]{"a", "a", "b"}));
    }

}
