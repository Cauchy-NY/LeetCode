package test;

import Hard.Question10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question10Test {

    Question10 q = new Question10();

    @Test
    public void test1() {
        assertEquals(true, q.isMatch("ab", "ab"));
    }

    @Test
    public void test2() {
        assertEquals(false, q.isMatch("aa", "a"));
    }

    @Test
    public void test3() {
        assertEquals(true, q.isMatch("aaaaab", "a*b"));
    }

    @Test
    public void test4() {
        assertEquals(false, q.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void test5() {
        assertEquals(true, q.isMatch("ab", ".*"));
    }

    @Test
    public void test6() {
        assertEquals(true, q.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test7() {
        assertEquals(true, q.isMatch("aa", "a*"));
    }

    @Test
    public void test8() {
        assertEquals(false, q.isMatch("abasdnsj", ".*c"));
    }

    @Test
    public void test9() {
        assertEquals(true, q.isMatch("abasdnsjc", ".*c"));
    }

    @Test
    public void test10() {
        assertEquals(true, q.isMatch("aaa", "a*a"));
    }

    @Test
    public void test11() {
        assertEquals(true, q.isMatch("aaa", "ab*a*c*a"));
    }
}
