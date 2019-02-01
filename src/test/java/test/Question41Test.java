package test;

import Hard.Question41;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question41Test {
    Question41 q = new Question41();

    @Test
    public void test1() {
        assertEquals(2, q.firstMissingPositive(new int[] {3, 4, -1, 1}));
    }
}
