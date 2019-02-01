package test;

import Medium.Question6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question6Test {

    Question6 q = new Question6();

    @Test
    public void test1() {
        assertEquals("PAHNAPLSIIGYIR", q.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void test2() {
        assertEquals("PINALSIGYAHRPI", q.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void test3() {
        assertEquals("A", q.convert("A", 1));
    }

    @Test
    public void test4() {
        assertEquals("A", q.convert("A", 3));
    }
}
