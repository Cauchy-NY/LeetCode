package test;

import Hard.Question45;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question45Test {

    Question45 q = new Question45();

    @Test
    public void test1() {
        assertEquals(2, q.jump(new int[] {2, 3, 1, 1, 4}));
    }

    @Test
    public void test2() {
        assertEquals(1, q.jump(new int[] {2, 1}));
    }
}
