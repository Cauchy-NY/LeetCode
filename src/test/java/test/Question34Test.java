package test;

import Medium.Question34;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Question34Test {

    Question34 q = new Question34();

    @Test
    public void test1() {
        assertArrayEquals(new int[] {5,6}, q.searchRange(new int[] {1,1,2,3,5,8,8,9,10}, 8));
    }
}
