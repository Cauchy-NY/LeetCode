package test;

import Hard.Question32;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question32Test {

    Question32 q = new Question32();

    @Test
    public void test1() {
        assertEquals(2, q.longestValidParentheses("(()"));
    }

    @Test
    public void test2() {
        assertEquals(6, q.longestValidParentheses("(())()"));
    }

    @Test
    public void test3() {
        assertEquals(6, q.longestValidParentheses("(())()("));
    }

    @Test
    public void test4() {
        assertEquals(6, q.longestValidParentheses("((())()"));
    }

    @Test
    public void test5() {
        assertEquals(0, q.longestValidParentheses("("));
    }

    @Test
    public void test6() {
        assertEquals(2, q.longestValidParentheses("())"));
    }
}
