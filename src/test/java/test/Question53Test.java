package test;

import Easy.Question53;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question53Test {

    Question53 q = new Question53();

    @Test
    public void test1() {
        assertEquals(6, q.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
