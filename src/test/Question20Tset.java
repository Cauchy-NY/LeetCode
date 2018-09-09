package test;

import Easy.Question20;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class Question20Tset {

    Question20 q = new Question20();

    @Test
    public void test1() {
        assertEquals(false, q.isValid("["));
    }

    @Test
    public void test2() {
        assertEquals(false, q.isValid("]"));
    }

    @Test
    public void test3() {
        assertEquals(true, q.isValid("[]{()}"));
    }
}
