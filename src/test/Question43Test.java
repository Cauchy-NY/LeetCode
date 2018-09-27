package test;

import Medium.Question43;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question43Test {

    Question43 q = new Question43();

    @Test
    public void test1() {
        assertEquals("6", q.multiply("2", "3"));
    }

    @Test
    public void test2() {
        assertEquals("56088", q.multiply("123", "456"));
    }

    @Test
    public void test3() {
        assertEquals("81", q.multiply("9", "9"));
    }
}
