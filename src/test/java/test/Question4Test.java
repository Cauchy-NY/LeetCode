package test;

import Hard.Question4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question4Test {

    Question4 q = new Question4();

    @Test
    public void test1() {
        assertEquals(1.0, q.findMedianSortedArrays(new int[]{1}, new int[]{1}));
    }

    @Test
    public void test2() {
        assertEquals(2.5, q.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
    }

}
