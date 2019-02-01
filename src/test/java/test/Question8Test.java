package test;

import Medium.Question8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question8Test {

    Question8 q = new Question8();

    @Test
    public void test1() {
        assertEquals(42, q.myAtoi("42"));
    }

    @Test
    public void test2() {
        assertEquals(-42, q.myAtoi("-42"));
    }

    @Test
    public void test3() {
        assertEquals(4193, q.myAtoi("4193 with words"));
    }

    @Test
    public void test4() {
        assertEquals(0, q.myAtoi("words and 987"));
    }

    @Test
    public void test5() {
        assertEquals(Integer.MIN_VALUE, q.myAtoi("-91283472332"));
    }

    @Test
    public void test6() {
        assertEquals(0, q.myAtoi(""));
    }

    @Test
    public void test7() {
        assertEquals(0, q.myAtoi(" "));
    }

    @Test
    public void test8() {
        assertEquals(3, q.myAtoi("3.14159"));
    }

    @Test
    public void test9() {
        assertEquals(0, q.myAtoi(".1"));
    }

    @Test
    public void test10() {
        assertEquals(0, q.myAtoi("-"));
    }

    @Test
    public void test11() {
        assertEquals(1, q.myAtoi("+1"));
    }
}
