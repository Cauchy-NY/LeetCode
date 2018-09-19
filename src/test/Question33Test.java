package test;

import Medium.Question33;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question33Test {

    Question33 q = new Question33();

    @Test
    public void test1() {
        assertEquals(4, q.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    @Test
    public void test2() {
        assertEquals(-1, q.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
