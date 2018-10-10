package test;

import Hard.Question52;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question52Test {

    Question52 q = new Question52();

    @Test
    public void test1() {
        assertEquals(2, q.totalNQueens(4));
    }

}
