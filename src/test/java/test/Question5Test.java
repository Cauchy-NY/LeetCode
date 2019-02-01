package test;

import Medium.Question5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question5Test {

    Question5 q = new Question5();

    @Test
    public void test1() {
        assertEquals("bb", q.longestPalindrome("cbbd"));
    }

    @Test
    public void test2() {
        assertEquals("aba", q.longestPalindrome("babad"));
    }
}
