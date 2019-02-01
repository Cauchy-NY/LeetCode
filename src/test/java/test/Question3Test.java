package test;

import Medium.Question3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question3Test {

    Question3 q = new Question3();

    @Test
    public void test1() {
        assertEquals(3, q.lengthOfLongestSubstring("abc"));
    }

    @Test
    public void test2() {
        assertEquals(1, q.lengthOfLongestSubstring("bbbb"));
    }

    @Test
    public void test3() {
        assertEquals(3, q.lengthOfLongestSubstring("pwwkew"));
    }

}
